package com.jacky.study.test;

import java.util.HashSet;
import java.util.Set;

public class IsBQ {
	/** 半角标点符号开始位置 */

	private static final int SINGLE_BYTE_SYMBOL_START = 0x0020;

	/** 半角标点符号结束位置 */

	private static final int SINGLE_BYTE_SYMBOL_END = 0x007E;

	/** 半角片假名开始位置 */

	private static final int SINGLE_BYTE_KATAKANA_START = 0xFF61;

	/** 半角片假名结束位置 */

	private static final int SINGLE_BYTE_KATAKANA_END = 0xFF9F;

	/** 半角空格 */

	private static final int SINGLE_BYTE_SPACE_END = 0x0020;

	/**

	 * 半角数字判定

	 * @return 判定結果 true:半角数字

	 */

	public static boolean isSingleByteDigit( final char c ) {

	    return ( '0' <= c ) && ( c <= '9' );

	}

	/**

	 * 半角英字判定

	 * @return 判定結果 true:半角英字

	 */

	public static boolean isSingleByteAlpha( final char c ) {

	    return ( ( 'a' <= c ) && ( c <= 'z' ) ) || ( ( 'A' <= c ) && ( c <= 'Z' ) );

	}

	/**

	 * 半角标点符号判定

	 * @return 判定結果 true:半角标点符号

	 */

	public static boolean isSingleByteSymbol( final char c ) {

	    return ( SINGLE_BYTE_SYMBOL_START <= c ) &&

	                ( c <= SINGLE_BYTE_SYMBOL_END ) && 

	                !isSingleByteAlpha( c ) && 

	                !isSingleByteDigit( c );

	}

	/**

	 * 半角片假名判定

	 * @return 判定結果 true:半角片假名

	 */

	public static boolean isSingleByteKatakana( final char c ) {

	    return ( SINGLE_BYTE_KATAKANA_START <= c ) && ( c <= SINGLE_BYTE_KATAKANA_END );

	}

	/**

	 * 半角空格判定

	 * @return 判定結果 true:半角空格

	 */

	public static boolean isSingleByteSpace( final char c ) {   

	    boolean bRet = false;    

	    if ( c == SINGLE_BYTE_SPACE_END ) {        

	        bRet = true;

	    }    

	    return bRet;

	}

	public static void main(String[] args) {
		String str = "!!！！去符号, ' \" ‘”标号！！当然。!!..**半角(23%)……";
		System.out.println(str);
		System.out.println(str.replaceAll("\\p{Punct}", ""));
		final char fullStop_en = '.';
		final char fullStop_zh = '。';
		Set<Character> ignoreSet = new HashSet<Character>();
		ignoreSet.add('*');
		ignoreSet.add('%');
		ignoreSet.add(' ');
		char c[] = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if(isSingleByteSymbol(c[i])){
				System.out.print(c[i]);
				if (c[i] == fullStop_en) {
					c[i] = fullStop_zh;
				} else if ((c[i] < '\177') && (!ignoreSet.contains(c[i]))) {
					c[i] = (char) (c[i] + 65248);
				}
			}
		}
		String result = new String(c);
		System.out.println();
		System.out.println(result);
	}
}
