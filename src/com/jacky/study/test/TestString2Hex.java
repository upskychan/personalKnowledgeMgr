package com.jacky.study.test;

public class TestString2Hex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abcdedf";
		int hashCode = str.hashCode();
		System.out.println(Integer.toBinaryString(hashCode));
		System.out.println(Integer.toOctalString(hashCode));
		System.out.println(Integer.toHexString(hashCode));
	}

}
