package com.jacky.study.html.cxextractor.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 在线性时间内抽取主题类（新闻、博客等）网页的正文。
 * 采用了<b>基于行块分布函数</b>的方法，为保持通用性没有针对特定网站编写规则。
 * </p>
 * @author Chen Xin(xchen@ir.hit.edu.cn)
 * Created on 2009-1-11
 * Updated on 2010-08-09
 */
public class TextExtract {
	
	private List<String> lines;
	private final static int blocksWidth=3;
	private int threshold;
	private String html;
	private boolean flag;
	private int start;
	private int end;
	private StringBuilder text;
	private ArrayList<Integer> indexDistribution;
	/** The Constant _titlePattern. */
	private final static String _titlePattern = "<title>(.*?)</title>";

	/** The Constant _titleRegexPattern. */
	private final static Pattern _titleRegexPattern = Pattern.compile(
			_titlePattern, Pattern.CANON_EQ | Pattern.DOTALL
					| Pattern.CASE_INSENSITIVE);

	/** The _title. */
	private String _title = "";
	
	public TextExtract() {
		lines = new ArrayList<String>();
		indexDistribution = new ArrayList<Integer>();
		text = new StringBuilder();
		flag = false;
		/* 当待抽取的网页正文中遇到成块的新闻标题未剔除时，只要增大此阈值即可。*/
		/* 阈值增大，准确率提升，召回率下降；值变小，噪声会大，但可以保证抽到只有一句话的正文 */
		threshold	= -1;   
	}
	

	/**
	 * 抽取网页正文，不判断该网页是否是目录型。即已知传入的肯定是可以抽取正文的主题类网页。
	 * 
	 * @param _html 网页HTML字符串
	 * @param needImg 是否需要图片
	 * 
	 * @return 网页正文
	 */
	public HtmlEntity parse(String _html, boolean needImg) {
		return parse(_html, false ,needImg);
	}
	
	/**
	 * 判断传入HTML，若是主题类网页，则抽取正文；否则输出<b>"unkown"</b>。
	 * 
	 * @param _html 网页HTML字符串
	 * @param _flag true进行主题类判断, 省略此参数则默认为false
	 * @param needImg 是否需要图片
	 * 
	 * @return 网页正文string
	 */
	public HtmlEntity parse(String _html, boolean _flag, boolean needImg) {
		flag = _flag;
		html = _html;
		extractTitle(html);
		List<ImgEntity> imgList = processImg(html);
		html = preProcess(html,needImg);
//		System.out.println(html);
		String resultContent = getText();
		HtmlEntity htmlEntity = new HtmlEntity(_title, resultContent);
		htmlEntity.setPics(imgList);
		return htmlEntity;
	}
	private static int FREQUENT_URL = 30;
	private static Pattern links = Pattern.compile("<[aA]\\s+[Hh][Rr][Ee][Ff]=[\"|\']?([^>\"\' ]+)[\"|\']?\\s*[^>]*>([^>]+)</a>(\\s*.{0,"+FREQUENT_URL+"}\\s*<a\\s+href=[\"|\']?([^>\"\' ]+)[\"|\']?\\s*[^>]*>([^>]+)</[aA]>){2,100}", Pattern.DOTALL);
	
	private static String preProcess(String source, boolean needImg) {
		
		source = source.replaceAll("(?is)<!DOCTYPE.*?>", "");
		source = source.replaceAll("(?is)<!--.*?-->", "");				// remove html comment
		source = source.replaceAll("(?is)<script.*?>.*?</script>", ""); // remove javascript
		source = source.replaceAll("(?is)<style.*?>.*?</style>", "");   // remove css
		source = source.replaceAll("&.{2,5};|&#.{2,5};", " ");			// remove special char
		
		//剔除连续成片的超链接文本（认为是，广告或噪音）,超链接多藏于span中
		source = source.replaceAll("<[sS][pP][aA][nN].*?>", "");
		source = source.replaceAll("</[sS][pP][aA][nN]>", "");

//		int len = source.length();
		
//		while ((source = links.matcher(source).replaceAll("")).length() != len)
//		{
//			len = source.length();
//		}
		
		
		source = links.matcher(source).replaceAll("");
		
		//防止html中在<>中包括大于号的判断
		source = source.replaceAll("<[^>'\"]*['\"].*['\"].*?>", "");

		if (needImg) {
			source = replaceSaveImg(source);
		} else {
			source = source.replaceAll("<.*?>", "");
			source = source.replaceAll("<.*?>", "");
		}
		source = source.replaceAll("\r\n", "\n");

		return source;
	
	}
	
	private static String replaceSaveImg(String source){
		// TODO 去除html标签，保留<img>
		
		//source = source.replaceAll("<(?!img)[\\s\\S]*?>", "");
		source = source.replaceAll("</?[^/?(img)][^><]*>", "");
		
		Pattern pattern = Pattern.compile("<.*?>", Pattern.DOTALL);
		Matcher pMatcher = pattern.matcher(source);
		while(pMatcher.find()){
			String tagStr = pMatcher.group();
			System.out.println(tagStr);
			if(!tagStr.startsWith("<img ")){
				source = pMatcher.replaceFirst("");
			}
		}
		return source;
	}
	
	private List<ImgEntity> processImg(String contentStr) {
//		String regexImage = "<img.+?src=\"(.+?)\".+?/?>";
		String regexImage = "<img.+?src\\s*=\\s*['|\"]?\\s*([^'\"\\s>]+).+?/?>?";
		String imageStr = "";
		String imageSrcStr = "";
		
		List<ImgEntity> imgList = new ArrayList<ImgEntity>();

		Pattern p = Pattern.compile(regexImage, Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(contentStr);
		
		int count = 1;
		while(m.find()) {
			imageStr = m.group() + "/>";
			imageSrcStr = m.group(1);
//			System.out.println(imageStr);
//			System.out.println(imageSrcStr);
			count ++;
			ImgEntity imgEntity = new ImgEntity();
			imgEntity.setId(count);
			imgEntity.setImgstr(imageStr);
			imgEntity.setImgsrc(imageSrcStr);
			imgList.add(imgEntity);
		}
		return imgList;
	}
	
	private String getText() {
		lines = Arrays.asList(html.split("\n"));
		indexDistribution.clear();
		
		int empty = 0;//空行的数量
		for (int i = 0; i < lines.size() - blocksWidth; i++) {
			
			if (lines.get(i).length() == 0)
			{
				empty++;
			}
			
			int wordsNum = 0;
			for (int j = i; j < i + blocksWidth; j++) { 
				lines.set(j, lines.get(j).replaceAll("\\s+", ""));
				wordsNum += lines.get(j).length();
			}
			indexDistribution.add(wordsNum);
			//System.out.println(wordsNum);
		}
		int sum = 0;

		for (int i=0; i< indexDistribution.size(); i++)
		{
			sum += indexDistribution.get(i);
		}
		
		threshold = Math.min(100, (sum/indexDistribution.size())<<(empty/(lines.size()-empty)>>>1));
		threshold = Math.max(50, threshold);
		
		start = -1; end = -1;
		boolean boolstart = false, boolend = false;
		boolean firstMatch = true;//前面的标题块往往比较小，应该减小与它匹配的阈值
		text.setLength(0);
		
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < indexDistribution.size() - 1; i++) {
			
			if(firstMatch && ! boolstart)
			{
				if (indexDistribution.get(i) > (threshold/2) && ! boolstart) {
					if (indexDistribution.get(i+1).intValue() != 0 
						|| indexDistribution.get(i+2).intValue() != 0) {
						firstMatch = false;
						boolstart = true;
						start = i;
						continue;
					}
				}
				
			}
			if (indexDistribution.get(i) > threshold && ! boolstart) {
				if (indexDistribution.get(i+1).intValue() != 0 
					|| indexDistribution.get(i+2).intValue() != 0
					|| indexDistribution.get(i+3).intValue() != 0) {
					boolstart = true;
					start = i;
					continue;
				}
			}
			if (boolstart) {
				if (indexDistribution.get(i).intValue() == 0 
					|| indexDistribution.get(i+1).intValue() == 0) {
					end = i;
					boolend = true;
				}
			}
		
			if (boolend) {
				buffer.setLength(0);
				//System.out.println(start+1 + "\t\t" + end+1);
				for (int ii = start; ii <= end; ii++) {
					if (lines.get(ii).length() < 5) continue;
					buffer.append(lines.get(ii) + "\n");
				}
				String str = buffer.toString();
				//System.out.println(str);
				if (str.contains("Copyright")  || str.contains("版权所有") ) continue; 
				text.append(str);
				boolstart = boolend = false;
			}
		}
		
		if (start > end)
		{
			buffer.setLength(0);
			int size_1 = lines.size()-1;
			for (int ii = start; ii <= size_1; ii++) {
				if (lines.get(ii).length() < 5) continue;
				buffer.append(lines.get(ii) + "\n");
			}
			String str = buffer.toString();
			//System.out.println(str);
			if ((!str.contains("Copyright"))  || (!str.contains("版权所有")) ) 
			{	
				text.append(str);
			}
		}
		
		return text.toString();
	}
	
	/**
	 * Extract title.
	 * 
	 * @param htmlText
	 *            the html text
	 */
	private void extractTitle(String htmlText) {
		Matcher m1 = _titleRegexPattern.matcher(htmlText);

		if (m1.find()) {
			_title = replaceSpecialChar(m1.group(1));
		}
		_title = _title.replaceAll("\n+", "");
	}
	
	/**
	 * Replace special char.
	 * 
	 * @param content
	 *            the content
	 * 
	 * @return the string
	 */
	private String replaceSpecialChar(String content) {
		String text = content.replaceAll("&quot;", "\"");
		text = text.replaceAll("&ldquo;", "“");
		text = text.replaceAll("&rdquo;", "”");
		text = text.replaceAll("&middot;", "·");
		text = text.replaceAll("&#8231;", "·");
		text = text.replaceAll("&#8212;", "——");
		text = text.replaceAll("&#28635;", "濛");
		text = text.replaceAll("&hellip;", "…");
		text = text.replaceAll("&#23301;", "嬅");
		text = text.replaceAll("&#27043;", "榣");
		text = text.replaceAll("&#8226;", "·");
		text = text.replaceAll("&#40;", "(");
		text = text.replaceAll("&#41;", ")");
		text = text.replaceAll("&#183;", "·");
		text = text.replaceAll("&amp;", "&");
		text = text.replaceAll("&bull;", "·");
		text = text.replaceAll("&lt;", "<");
		text = text.replaceAll("&#60;", "<");
		text = text.replaceAll("&gt;", ">");
		text = text.replaceAll("&#62;", ">");
		text = text.replaceAll("&nbsp;", " ");
		text = text.replaceAll("&#160;", " ");
		text = text.replaceAll("&tilde;", "~");
		text = text.replaceAll("&mdash;", "—");
		text = text.replaceAll("&copy;", "@");
		text = text.replaceAll("&#169;", "@");
		text = text.replaceAll("♂", "");
		text = text.replaceAll("\r\n|\r", "\n");

		return text;
	}
	
	public static void main(String[] args) {
		System.out.println("===============");
		String s = "<img  class='fit-image' onload='javascript:if(this.width>498)this.width=498;' />hello";
		// source = source.replaceAll("<[^'\"]*['\"].*['\"].*?>", "");
		System.out.println(TextExtract.preProcess(s,false));
	}
}
