package com.jacky.study.test;

public class TestStatic {
	public static int a = 0;
	public int b = 0;
	
	private void add(){
		a++;
		b++;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestStatic t1 = new TestStatic();
		t1.add();
		TestStatic t2 = new TestStatic();
		t2.add();
		System.out.println("a="+t2.a);
		System.out.println("b="+t2.b);
	}

}
