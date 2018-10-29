package com.jacky.study.test;

public class StringInitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String a = new String("abc");
		String b = "abc";
		String c = "abc";
		String d = new String("abc");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(c.hashCode());
		System.out.println(d.hashCode());
		//主要要注意常量字符串会自动合并，例如上面的b和c是常量字符串，所以自动合并了
		if(a==b) {
			System.out.println("a==b");
		}else{
			System.out.println("a!=b");
		}
		
		if(b==c) {
			System.out.println("b==c");
		}else{
			System.out.println("b!=c");
		}
		
		if(a==d) {
			System.out.println("a==d");
		}else{
			System.out.println("a!=d");
		}
		
		b = b.concat("d");
		System.out.println("b="+b);
		System.out.println("c="+c);
	}

}
