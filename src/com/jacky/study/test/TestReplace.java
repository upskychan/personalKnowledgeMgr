package com.jacky.study.test;

public class TestReplace {
	public static void main(String[] args) {
		String str = "a  b c";
		str = str.replaceAll(" ", "&nbsp;");
		System.out.println(str);
		
		Integer a = 123456;
		Integer b = 123456;
		System.out.println(a==b);
		System.out.println(a.equals(b));
	}
}
