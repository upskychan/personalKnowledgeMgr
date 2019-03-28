package com.jacky.study.finalize;

public class TestTermination {
	public static void main(String[] args) {
		Book book = new Book();
		book.init();
		System.gc();
		try {
			Thread.sleep(10000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
