package com.jacky.study.exception;

public class TestFinally {
	public static int add(int num){
		int result = 0;
		try {
			result =  100 / num;
			System.out.println("try");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("catch");
			return 2;
		} finally{
			System.out.println("finally");
		}
//		return 3;
	}
	
	public static void main(String[] args) {
		System.out.println(add(3));
		System.out.println("************************************");
		System.out.println(add(0));
	}
}
