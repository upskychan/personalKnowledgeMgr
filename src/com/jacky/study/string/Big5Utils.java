package com.jacky.study.string;

import java.io.UnsupportedEncodingException;

/**
 * 中文简体繁体转换（有点问题，会乱码）.
 * 
 * @author upsky
 *
 */
public class Big5Utils {
	/**
	 * 繁体转简体.
	 * 
	 * @param s
	 *            繁体
	 * @return 简体
	 */
	public static String big5ToChinese(String s) {
		if (null == s || "".equals(s)) {
			return "";
		}
		String newStr = null;
		try {
			newStr = new String(s.getBytes("big5"), "gb2312");
			// newStr = new String(s.getBytes("UTF-8"), "big5");
			return newStr;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 简体转繁体.
	 * 
	 * @param s
	 *            简体
	 * @return 繁体
	 */
	public static String chineseToBig5(String s) {
		if (null == s || "".equals(s)) {
			return "";
		}
		String newStr = null;
		try {
			newStr = new String(s.getBytes("gb2312"), "big5");
			return newStr;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return s;
	}

	public static void main(String[] args) {
		String big5Str = "中華人民共和國";
		String chineseStr = Big5Utils.big5ToChinese(big5Str);
		System.out.println(chineseStr);
		System.out.println(Big5Utils.chineseToBig5(chineseStr));
	}

}
