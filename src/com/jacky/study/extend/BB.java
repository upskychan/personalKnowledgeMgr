package com.jacky.study.extend;

public class BB extends AA {
	public static void main(String[] args) {
		BB bb = new BB();
		// 无法继承AA类的private成员，但是能继承AA类的protected和public成员
		System.out.println(bb.b);
		System.out.println(bb.c);
		bb.b();
		bb.c();
		AA aa = new AA();
		// 无法访问AA类中的private成员，但是能访问AA类的protected（因为在同一个包中）和public成员
		System.out.println(aa.b);
		System.out.println(aa.c);
		aa.b();
		aa.c();
	}
}
