package com.jacky.study.test;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BQChange {

	// 全角转半角的 转换函数
	public static final String full2HalfChange(String qjStr)
			throws UnsupportedEncodingException {
		StringBuffer outStrBuf = new StringBuffer("");
		String tStr = "";
		byte[] b = null;

		for (int i = 0; i < qjStr.length(); i++) {
			tStr = qjStr.substring(i, i + 1);
			// 全角空格转换成半角空格
			if (tStr.equals("　")) {
				outStrBuf.append(" ");
				continue;
			}

			b = tStr.getBytes("unicode");
			// 得到 unicode 字节数据
			if (b[2] == -1) {
				// 表示全角？
				b[3] = (byte) (b[3] + 32);
				b[2] = 0;
				outStrBuf.append(new String(b, "unicode"));
			} else {
				outStrBuf.append(tStr);
			}
		} // end for.
		return outStrBuf.toString();
	}

	// 半角转全角
	public static final String half2Fullchange(String bjStr)
			throws UnsupportedEncodingException {
		StringBuffer outStrBuf = new StringBuffer("");
		String tStr = "";
		byte[] b = null;

		for (int i = 0; i < bjStr.length(); i++) {
			tStr = bjStr.substring(i, i + 1);
			if (tStr.equals(" ")) {
				// 半角空格
				outStrBuf.append(tStr);
				continue;
			}

			b = tStr.getBytes("unicode");
			if (b[2] == 0) {
				// 半角?
				b[3] = (byte) (b[3] - 32);
				b[2] = -1;
				outStrBuf.append(new String(b, "unicode"));
			} else {
				outStrBuf.append(tStr);
			}
		}
		return outStrBuf.toString();
	}

	/**
	 * 半角转全角.
	 * 
	 * @param bjStr
	 *            半角字符串
	 * @return 全角字符串
	 */
	public static String filtString(String bjStr) {
		bjStr = bjStr.replaceAll("\\\\", "");
		char c[] = bjStr.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				c[i] = '\u3000';
			} else if (c[i] < '\177') {
				c[i] = (char) (c[i] + 65248);
			}
		}
		return new String(c);
	}
	
	/**
	 * 半角转全角.
	 * 
	 * @param bjStr
	 *            半角字符串
	 * @return 全角字符串
	 */
	public static String filtString2(String bjStr) {
		if(null == bjStr || bjStr.length()<1){
			return bjStr;
		}
		StringBuffer outStrBuf = new StringBuffer("");
		Pattern pattern = Pattern.compile("\\p{Punct}");
		byte[] b = null;
		for(int i=0;i<bjStr.length();i++){
			String letter = bjStr.substring(i, i + 1);
			try {
				Matcher matcher = pattern.matcher(letter);
				if(matcher.find()){
					b = letter.getBytes("unicode");
					if (b[2] == 0) {
						// 半角?
						b[3] = (byte) (b[3] - 32);
						b[2] = -1;
						outStrBuf.append(new String(b, "unicode"));
					} else {
						outStrBuf.append(letter);
					}
				} else {
					outStrBuf.append(letter);
				}
			} catch (Exception e) {
				outStrBuf.append(letter);
			}
		}
		return outStrBuf.toString();
	}
	
	public static String filtString3(String bjStr) {
		if(null == bjStr || bjStr.length()<1){
			return bjStr;
		}
		StringBuffer outStrBuf = new StringBuffer("");
		Pattern pattern = Pattern.compile("\\p{Punct}");
		byte[] b = null;
			try {
				Matcher matcher = pattern.matcher(bjStr);
				while(matcher.find()){
					System.out.println(matcher.group());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return outStrBuf.toString();
	}

	public static void test2() throws UnsupportedEncodingException {

		// 全角转半角
		String QJstr = "hello!！ 全角转换，ＤＡＯ ５３２３２　。";
		String result = full2HalfChange(QJstr);
		System.out.println(QJstr);
		System.out.println(result);
		System.out.println("------------------------------------");

		// 半角转全角
		String str = "java 汽车 召回 2345,.;:'!@#";
		System.out.println(str);
		System.out.println(half2Fullchange(str));
		
		String t = "    受访者反对征收拥堵费的原因，依次是：“治堵更应该从城市规划、道路施工以及交通管控等方面入手”(66.2%)，“购车者缴纳的税费已经包括了交通管理费用，不应重复征收”(58.7%)，“公共交通尚不完善，并不能真正解决拥堵”(54.6%)。";
		System.out.println(t);
		System.out.println(half2Fullchange(t));
	}

	public static void main(String[] args) {
		 String str = "我在,进行!半全！角 的.转 换 测试。";
		 str = "    受访者反对征收拥堵费的原因，依次是：“治堵更应该从城市规划、道路施工以及交通管控等方面入手”(66.2%)，“购车者缴纳的税费已经包括了交通管理费用，不应重复征收”(58.7%)，“公共交通尚不完善，并不能真正解决拥堵”(54.6%)。";
		 str = "    核心提示    补贴    会发多少?？    \" '“取消一般公务用车,就是说厅级以下干部都没有公车了。";
		 str = "!!！！去符号, ' \" ‘”标号！！当然。!!..**半角";
		 System.out.println(str);
		 System.out.println(filtString3(str));
//		 System.out.println(str.replaceAll("[\\pP‘’“”]", ""));
//		 System.out.println(str.replaceAll("\\p{Punct}", ""));
//		 char a = '\'';
//		 a = (char) (a + 65248);
//		 System.out.println('\'');
//		 System.out.println(a);
		 
		 
//		try {
//			test2();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
	}

}
