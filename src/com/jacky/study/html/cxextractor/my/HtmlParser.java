package com.jacky.study.html.cxextractor.my;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mozilla.intl.chardet.nsDetector;
import org.mozilla.intl.chardet.nsICharsetDetectionObserver;
import org.mozilla.intl.chardet.nsPSMDetector;

import com.jacky.study.html.cxextractor.my.TextExtract;

public class HtmlParser {
	
	public String getHTML(String strURL) throws IOException {
		URL url = new URL(strURL);
		BufferedInputStream in =  new BufferedInputStream(url.openStream());
		byte[] bytes = new byte[1024000];
		int len = -1;
		int pos = 0;
		while ((len = in.read(bytes, pos, bytes.length - pos)) != -1) {
			pos += len;
		}
		
		detectCharset(bytes);
		
		String html = null;
		if (detCharset != null)
		{
			html = new String(bytes, 0, pos, this.detCharset);
		}
		else
		{
			return new String(bytes, 0, pos);
		}
		System.out.println("Detcharset = " + detCharset);
		return html;
	}
	
	private String detCharset = null;

	private Pattern pGB2312 = Pattern.compile("GB2312", Pattern.CASE_INSENSITIVE);
	private Pattern pUTF8 = Pattern.compile("(UTF8)|(UTF-8)", Pattern.CASE_INSENSITIVE);
	
	public void detectCharset(byte[] content)
	{
		String html = new String(content); 
		Matcher m = pGB2312.matcher(html);
		if (m.find())
		{
			detCharset = "gb2312";
			return ;
		}
		m = pUTF8.matcher(html);
		if (m.find())
		{
			detCharset = "utf-8";
			return;
		}
		
		int lang = nsPSMDetector.ALL;
		nsDetector det = new nsDetector(lang);
		det.Init(new nsICharsetDetectionObserver() {
			public void Notify(String charset) {
				detCharset = charset;
			} 
		});
		boolean isAscii = true;

		if (isAscii)
			isAscii = det.isAscii(content, content.length);

		if (!isAscii)
			det.DoIt(content, content.length, false);

		det.DataEnd();

		boolean found = false;
		if (isAscii) {
			this.detCharset = "US-ASCII";
			found = true;
		}

		if (!found && detCharset == null) {
			detCharset = det.getProbableCharsets()[0];
		}
	}
	
	public static void main(String[] args) {
		String url = "http://www.csdn.net/article/2014-08-27/2821403-the-top-9-of-ali-bigdata-competition";
		url = "http://www.csdn.net/article/2014-08-29/2821444-Servo";
		HtmlParser parser = new HtmlParser();
		String content = null;
		try {
			content = parser.getHTML(url);
			/* 
			 * 当待抽取的网页正文中遇到成块的新闻标题未剔除时，只要增大此阈值即可。
			 * 相反，当需要抽取的正文内容长度较短，比如只有一句话的新闻，则减小此阈值即可。
			 * 阈值增大，准确率提升，召回率下降；值变小，噪声会大，但可以保证抽到只有一句话的正文 
			 */
			//TextExtract.setThreshold(76); // 默认值86
			
			HtmlEntity htmlEntity = new TextExtract().parse(content,false);
			
			System.out.println(htmlEntity.getTitle());
			System.out.println(htmlEntity.getContent());
			for(ImgEntity imgEntity : htmlEntity.getPics()) {
				System.out.println(imgEntity.getImgsrc());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
