package com.jacky.study.test;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String word = "2016年2=4月13日=0.600000";
		word = "2016年24月13日=0.600000";
		String array1[] = word.split("=");
		System.out.println(array1.length);
		System.out.println(array1);
		
		
		
		String __IR_CHANNEL = "财经视点";
		__IR_CHANNEL = " ";
		String array[] = __IR_CHANNEL.split("[_0-9]");
		System.out.println(array);
		System.out.println(array.length);
		
		
		String pram1 = null;
		String pram2 = null;
		if (null == pram1) {
			System.out.println("1");
		} else if (null == pram1 && null == pram2) {
			System.out.println("2");
		} else {
			System.out.println("3");
		}

	}

}
