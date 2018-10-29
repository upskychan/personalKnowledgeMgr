package com.jacky.study.html.cxextractor;

/**
 * @author Xin Chen
 * Created on 2009-11-11
 * Updated on 2010-08-09
 * Email:  xchen@ir.hit.edu.cn
 * Blog:   http://hi.baidu.com/爱心同盟_陈鑫
 * Modified By : Yang @ http://www.chainlt.com
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 在线性时间内抽取主题类（新闻、博客等）网页的正文。 采用了<b>基于行块分布函数</b>的方法，为保持通用性没有针对特定网站编写规则。
 * </p>
 * 
 * @author Chen Xin
 * @version 1.0, 2009-11-11
 */
public class TextExtract4Pic {

	private static List<String> lines;
	private final static int blocksWidth;
	private static int threshold;
	private static String html;
	private static boolean flag;
	private static int start;
	private static int end;
	private static StringBuilder text;
	private static ArrayList<Integer> indexDistribution;
	private static List<String> old_lines;
	private static String oldhtml;

	static {
		lines = new ArrayList<String>();
		indexDistribution = new ArrayList<Integer>();
		text = new StringBuilder();
		blocksWidth = 3;
		flag = false;
		/* 当待抽取的网页正文中遇到成块的新闻标题未剔除时，只要增大此阈值即可。 */
		/* 阈值增大，准确率提升，召回率下降；值变小，噪声会大，但可以保证抽到只有一句话的正文 */
		threshold = 86;
	}

	public static void setthreshold(int value) {
		threshold = value;
	}

	/**
	 * 抽取网页正文，不判断该网页是否是目录型。即已知传入的肯定是可以抽取正文的主题类网页。
	 *
	 * @param _html
	 *            网页HTML字符串
	 *
	 * @return 网页正文string
	 */
	public static String parse(String _html) {
		return parse(_html, false);
	}

	/**
	 * 判断传入HTML，若是主题类网页，则抽取正文；否则输出<b>"unkown"</b>。
	 *
	 * @param _html
	 *            网页HTML字符串
	 * @param _flag
	 *            true进行主题类判断, 省略此参数则默认为false
	 *
	 * @return 网页正文string
	 */
	public static String parse(String _html, boolean _flag) {
		flag = _flag;
		html = _html;
		preProcess();
		// System.out.println(html);
		return getText();
	}

	private static void preProcess() {
		html = html.replaceAll("(?is)<!DOCTYPE.*?>", "");
		html = html.replaceAll("(?is)<!--.*?-->", ""); // remove html comment
		html = html.replaceAll("(?is)<script.*?>.*?</script>", ""); // remove
																	// javascript
		html = html.replaceAll("(?is)<style.*?>.*?</style>", ""); // remove css
		html = html.replaceAll("(?is)style=\".*?\"", ""); // remove css
		html = html.replaceAll("&.{2,5};|&#.{2,5};", " "); // remove special
															// char
		oldhtml = html;
		html = html.replaceAll("(?is)<.*?>", "");
		// <!--[if !IE]>|xGv00|9900d21eb16fa4350a3001b3974a9415<![endif]-->
	}

	private static String getText() {
		lines = Arrays.asList(html.split("\n"));
		old_lines = Arrays.asList(oldhtml.split("\n"));
		indexDistribution.clear();
		boolean haveimg_arr[] = new boolean[old_lines.size()];

		for (int i = 0; i < lines.size() - blocksWidth; i++) {
			int wordsNum = 0;
			for (int j = i; j < i + blocksWidth; j++) {
				lines.set(j, lines.get(j).replaceAll("\\s+", ""));
				wordsNum += lines.get(j).length();
			}
			indexDistribution.add(wordsNum);
			// System.out.println(wordsNum);
			if (old_lines.get(i).toLowerCase().contains("<img")) {
				haveimg_arr[i] = true;
			}
		}

		start = -1;
		end = -1;
		boolean boolstart = false, boolend = false;
		text.setLength(0);

		for (int i = 0; i < indexDistribution.size() - 1; i++) {
			if (indexDistribution.get(i) > threshold && !boolstart) {
				if (indexDistribution.get(i + 1).intValue() != 0
						|| indexDistribution.get(i + 2).intValue() != 0
						|| indexDistribution.get(i + 3).intValue() != 0) {
					boolstart = true;
					start = i;
					continue;
				}
			}
			if (boolstart) {
				if (haveimg_arr[i]) {
					continue;
				}
				if (indexDistribution.get(i).intValue() == 0
						|| indexDistribution.get(i + 1).intValue() == 0) {
					end = i;
					boolend = true;
				}
			}
			if (boolend) {

				StringBuilder tmp = new StringBuilder();
				// System.out.println(start+1 + "\t\t" + end+1);
				for (int ii = start; ii <= end; ii++) {
					if (haveimg_arr[ii]) {
						String img = getImg(old_lines.get(ii));
						if (img == null)
							continue;
						tmp.append(img + "\n");
						continue;
					}
					if (lines.get(ii).length() < 5)
						continue;

					tmp.append("<p>" + lines.get(ii) + "</p>\n");
				}
				String str = tmp.toString();
				// System.out.println(str);
				if (str.contains("Copyright") || str.contains("版权所有"))
					continue;
				text.append(str);
				boolstart = boolend = false;
			}
		}
		return text.toString();
	}

	public static String getImg(String s) {
		String img = "";
//		img = TextTool.getBetweenOne(s, "<img", "</img>");
//		if (img == null) {
//			img = TextTool.getBetweenOne(s, "<img", "/>");
//		} else {
//			img = "<img" + img + "</img>";
//		}
//		if (img != null) {
//			img = "<img" + img + "/>";
//		}

		return img;
	}
}
