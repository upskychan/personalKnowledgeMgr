package com.jacky.study.finalize;

public class Book {
	public void init() {
		System.out.println("initing...");
	}

	protected void finalize() {
		System.out.println("downing...");
	}
}
