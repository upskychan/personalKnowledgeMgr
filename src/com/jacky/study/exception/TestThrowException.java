package com.jacky.study.exception;

public class TestThrowException {
	public static void main(String[] args) {
		try {
			int result = m1(-1);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int m1(int num) throws Exception{
		if(num < 0) {
			throw new Exception("我错了");//发生异常后，直接捕获异常处理了，无返回值
		}
		return 1;
	}

}
