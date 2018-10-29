package com.jacky.study.html.basejsoup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.jacky.study.html.cxextractor.UseDemo;


/**
 * <p>
 * 在线性时间内抽取主题类（新闻、博客等）网页的正文。 采用了<b>基于行块分布函数</b>的方法，为保持通用性没有针对特定网站编写规则。
 * 核心代码参考网络上陈鑫所写的TextExtract.java编写而成，加入了高亮显示的功能。
 * </p>
 * 
 * @author 倪庆洋
 * @version 1.0, 2013-08-05
 */
public class TextExtractor {

	private final int blocksWidth;
	private int threshold;
	
	private static final Pattern startPattern = Pattern.compile("^[0-9\u4e00-\u9fa5].+?");
	private static final Pattern endPattern = Pattern.compile(".+([0-9\u4e00-\u9fa5，。！？])$+?");

	public TextExtractor() {
		this.blocksWidth = 3;
		/* 当待抽取的网页正文中遇到成块的新闻标题未剔除时，只要增大此阈值即可。 */
		/* 阈值增大，准确率提升，召回率下降；值变小，噪声会大，但可以保证抽到只有一句话的正文 */
		this.threshold = 86;
	}

	public void setThreshold(int value) {
		this.threshold = value;
	}

	/**
	 * 提取正文，判断传入HTML，若是主题类网页，则抽取正文
	 * 
	 * @param html
	 *            网页HTML字符串
	 * 
	 * @return 网页正文string
	 */
	public String extract(String html) {
		StringBuilder text = new StringBuilder();
		for (TextLine textLine : this.parse(html)) {
			if (textLine.isContent()) {
				text.append(textLine.getLineText());
				text.append("\n");
			}
		}
		return text.toString();
	}

	
	/**
	 * 高亮显示
	 * @param html 网页原文
	 * @return 加入高亮显示后的网页原文
	 */
	public String highLighter(String html) {
		
		List<TextLine> lines = this.parse(html);
		
		//移除注释
		html = html.replaceAll("(?is)<!--.*?-->", ""); // remove html comment
		//格式化
		html = Jsoup.parse(html).html();
		
		List<String> htmlLines = Arrays.asList(html.split("\n"));
		for (TextLine textLine : lines) {
			if(textLine.getLineNumber() >= htmlLines.size()){
				continue;
			}
			if (textLine.isContent()) {
				Element bodyElement = Jsoup.parse(textLine.getLineHtml()).body();
				if(!textLine.getLineHtml().trim().startsWith("<") || !textLine.getLineHtml().trim().endsWith(">")){
					bodyElement.html("<span class='x-boilerpipe-mark1'>"+bodyElement.html()+"<span>");
				}else{
					for (Element element : bodyElement.children()) {
//						System.out.println(element.outerHtml());
//						element.addClass("x-boilerpipe-mark1");
						element.html("<span class='x-boilerpipe-mark1'>"+element.html()+"</span>");
					}
				}
				htmlLines.set(textLine.getLineNumber(), bodyElement.html());
			}
			
		}
		StringBuilder text = new StringBuilder();
		for (String htmlLine : htmlLines) {
			text.append(htmlLine);
			text.append("\n");
		}
		Document document = Jsoup.parse(text.toString());
		document.head().prepend("<style type='text/css'>.x-boilerpipe-mark1 { text-decoration:none; background-color: #ffff42 !important; color: black !important; visibility:visible !important;}</style>");
		return document.html();
	}
	/**
	 * 预处理
	 * @param html
	 * @return
	 */
	private String preProcess(String html) {
		html = html.replaceAll("(?is)<!DOCTYPE.*?>", "");
		html = html.replaceAll("(?is)<!--.*?-->", ""); // remove html comment
		html = html.replaceAll("(?is)<script.*?>.*?</script>", ""); // remove
		// javascript
		html = html.replaceAll("(?is)<style.*?>.*?</style>", ""); // remove css
		html = html.replaceAll("&.{2,5};|&#.{2,5};", " "); // remove special
		// char
		html = html.replaceAll("(?is)<.*?>", "");
		// <!--[if !IE]>|xGv00|9900d21eb16fa4350a3001b3974a9415<![endif]-->
		return html;
	}

	/**
	 * 判断传入HTML，若是主题类网页，则抽取正文；否则输出<b>"unkown"</b>。
	 * 
	 * @param html
	 *            网页HTML字符串
	 * @param flag
	 *            true进行主题类判断, 省略此参数则默认为false
	 * 
	 * @return 网页正文string
	 */
	private List<TextLine> parse(String html) {

		//移除注释
		html = html.replaceAll("(?is)<!--.*?-->", ""); // remove html comment
		
		//格式化
		html = Jsoup.parse(html).html();
		
		List<String> htmlLines = Arrays.asList(html.split("\n"));
		
		List<TextLine> lines = new ArrayList<TextLine>();
		
		for (int i = 0; i < htmlLines.size(); i++) {
			
			boolean flag = false;
			
			TextLine textLine = new TextLine();
			
			String htmlLine = htmlLines.get(i);
			
			if(htmlLine == null){
				flag = true;
				textLine.setLineHtml("");
				textLine.setLineText("");
			}else{
				Element body = Jsoup.parse(htmlLine).body();
				if(body == null){
					flag = true;
					textLine.setLineHtml("");
					textLine.setLineText("");
				}else{
					String content = body.html().trim();
					
					if ((StringUtils.isBlank(this.preProcess(content)) || content.startsWith("<") || (startPattern.matcher(content).matches() || endPattern.matcher(content).matches()))) {
						flag = true;
						textLine.setLineHtml(htmlLines.get(i));
						textLine.setLineText(this.preProcess(content));
					}
				}
			}
			
			if(flag){
				textLine.setLineNumber(i);
				textLine.setContent(false);
				lines.add(textLine);
			}
			
		}
		
		ArrayList<Integer> indexDistribution = new ArrayList<Integer>();
		
		for (int i = 0; i < lines.size() - blocksWidth; i++) {
			int wordsNum = 0;
			for (int j = i; j < i + blocksWidth; j++) {
				TextLine textLine = lines.get(j);
				String text = textLine.getLineText().replaceAll("\\s+", "");
				textLine.setLineText(text);
				wordsNum += text.length();
			}
			indexDistribution.add(wordsNum);
			// System.out.println(wordsNum);
		}

		int start = -1;
		int end = -1;
		boolean boolstart = false, boolend = false;

		for (int i = 0; i < indexDistribution.size() - 1; i++) {
			if (indexDistribution.get(i) > threshold && !boolstart) {
				if (indexDistribution.get(i + 1).intValue() != 0 || indexDistribution.get(i + 2).intValue() != 0 || indexDistribution.get(i + 3).intValue() != 0) {
					boolstart = true;
					start = i;
					continue;
				}
			}
			if (boolstart) {
				if (indexDistribution.get(i).intValue() == 0 || indexDistribution.get(i + 1).intValue() == 0) {
					end = i;
					boolend = true;
				}
			}
			if (boolend) {
				StringBuilder tmp = new StringBuilder();
				// System.out.println(start+1 + "\t\t" + end+1);
				List<Integer> tempList = new ArrayList<Integer>();
				for (int ii = start; ii <= end; ii++) {
					if (lines.get(ii).getLineText().length() < 5) {
						continue;
					}
					tmp.append(lines.get(ii).getLineText());
					tmp.append("\n");
					tempList.add(ii);
				}
				String str = tmp.toString();
//				System.out.println(str);
//				System.out.println("--------------------------------");
				if (str.contains("Copyright") && str.contains("版权所有")) {
					continue;
				}
				for (int j = 0; j < tempList.size(); j++) {
					lines.get(tempList.get(j)).setContent(true);
				}
				boolstart = boolend = false;
			}
		}

		return lines;
	}
	
	public class TextLine {

		private int lineNumber = 0;
		// 行内容,未经处理过的带标签的行
		private String lineHtml = null;
		private String lineText = null;
		// 判断是否为内容
		private boolean isContent = false;;

		public int getLineNumber() {
			return lineNumber;
		}

		public void setLineNumber(int lineNumber) {
			this.lineNumber = lineNumber;
		}

		public String getLineHtml() {
			return lineHtml;
		}

		public void setLineHtml(String lineHtml) {
			this.lineHtml = lineHtml;
		}

		public String getLineText() {
			return lineText;
		}

		public void setLineText(String lineText) {
			this.lineText = lineText;
		}

		public boolean isContent() {
			return isContent;
		}

		public void setContent(boolean isContent) {
			this.isContent = isContent;
		}

	}

	public static void main(String[] args) throws Exception {
		
		String url = "http://zj.qq.com/zt2013/fish/index.htm";
		url = "http://www.qq.com";
		url = "http://zj.qq.com/a/20130704/004077.htm";
		url = "http://www.hubei.gov.cn/zwgk/hbyw/hbywqb/201308/t20130802_461780.shtml";
		url = " http://datalib.finance.qq.com/peoplestar/267/index.shtml  ";
		url = "http://ru.qq.com/a/20130702/007500.htm ";
		url = "http://finance.sina.com.cn/focus/hdrf/";
		url = "http://finance.sina.com.cn/column/complain/20130805/111116346948.shtml";
		url = "http://view.news.qq.com/zt2013/ysdjt209/index.htm ";
		url = "  http://cq.qq.com/a/20130624/006409.htm";
		url = "http://blog.qq.com/qzone/153173717/1374428733.htm ";
		url = "http://www.csdn.net/article/2014-08-26/2821392-KConV3-Hacker";
		
		//此处缺失的类，自己写即可，只要读取出html内容就可以进行测试
//		byte[] data = HtmlUtil.readURLToBytes(url);
//		String html = EncodingUtil.toString(data);
		
		String html = new UseDemo().getHTML(url);
		
		String content = new TextExtractor().extract(html);
		System.out.println(content);
	}
}
