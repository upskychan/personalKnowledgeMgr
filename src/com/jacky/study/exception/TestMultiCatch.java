package com.jacky.study.exception;

public class TestMultiCatch {
	public static void main(String[] args) {
		try {
			System.out.println("111111");
			try {
				m1();
			} catch (Exception e) {
				System.out.println("22222");//会触发
				e.printStackTrace();
			}finally{
				//里外都会触发
				System.out.println("finally inner");
			}
		} catch (Exception e) {
			System.out.println("33333");//不触发
			e.printStackTrace();
		}finally{
			//里外都会触发
			System.out.println("finally outter");
		}
	}
	
	public static void m1() throws Exception{
		throw new Exception("m1 Exception");
	}

}
