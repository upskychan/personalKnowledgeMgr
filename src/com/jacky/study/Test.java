package com.jacky.study;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello,everybody!\n I am comming!");
		
		int i = Integer.MIN_VALUE;
		System.out.println(i + " : " + Integer.toBinaryString(i));
		i = Integer.MAX_VALUE;
//		i++;
		System.out.println(i + " : " + Integer.toBinaryString(i));
		
		System.out.println("**************************************");
		
		String[] a =  new String[10];
		int[] b = new int[10];
		System.out.println(a[5]);
		System.out.println(a.length);
		System.out.println(b[5]);
		System.out.println(b.length);
		
		System.out.println(Math.round(-11.5));
	}
}
