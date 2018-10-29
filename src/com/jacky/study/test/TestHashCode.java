package com.jacky.study.test;

public class TestHashCode {
	public static void main(String[] args){
		Object obj = new Object();
		System.out.println(obj.hashCode());// hashCode=798740
		Object obj2 = new Object();
		System.out.println(obj2.hashCode());// hashCode=2661678
		// obj的hashCode不等于obj2的hashCode

		Long long1 = Long.valueOf("10");
		Long long2 = Long.valueOf("10");
		Long long3 = new Long(10);
		System.out.println(long1.hashCode());// hashCode=10
		System.out.println(long2.hashCode());// hashCode=10
		System.out.println(long3.hashCode());// hashCode=10
		System.out.println(long1.equals(long2));// true
		System.out.println(long1.equals(long3));// true
		System.out.println(long1 == long2);// true
		System.out.println(long1 == long3);// false
		long1++;
		System.out.println(long1);// 11
		System.out.println(long2);// 10
	}
}
