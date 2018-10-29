package com.jacky.study.finalize;

public class TestTermination {
	public static void main(String[] args) {
		Book book = new Book();
		book.init();
		System.gc();
	}
}
