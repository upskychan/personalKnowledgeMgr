package com.jacky.study.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 替换html标签外的空格为&nbsp;
 * @author chenjie
 * @times 2014-1-10 下午5:59:10
 *
 */
public class TestReplaceStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String html = "<p> 1234 </p><p> 56<p>78 </p></p><p> <img src=\"http://yq.qq.com/ueditor/jsp/upload/20140110/58781389343774879.png\" title=\"vlcsnap-2013-12-26-09h32m17s246.png\"/></p><p><br/></p><p>333</p>";
//		html = html.replaceAll("[(?n)(?<=(^|>)[^<>]*)\\s(?=[^<>]*(<|$))]", "&nbsp;");
		System.out.println(html);
		Pattern p = Pattern.compile("(?<=^|>)[^<>]+(?=<|$)");
		Matcher m = p.matcher(html);
		StringBuffer sb = new StringBuffer(); 
		boolean result = m.find();
		while(result){
			String find = m.group();
			find = find.replaceAll(" ", "&nbsp;");
			m.appendReplacement(sb, find);
//			System.out.println(find);
			result = m.find();
		}
		m.appendTail(sb);
		System.out.println(sb);
	}

}
