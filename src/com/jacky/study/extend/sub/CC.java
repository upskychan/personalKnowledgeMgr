package com.jacky.study.extend.sub;

import com.jacky.study.extend.AA;

public class CC extends AA {
	public static void main(String[] args) {
		CC cc = new CC();
		// CC类无法继承AA类的private成员，但是能继承AA类的protected和public成员
		System.out.println(cc.b);
		System.out.println(cc.c);
		cc.b();
		cc.c();
		AA aa = new AA();
		// 无法访问AA类的private和protected成员
		System.out.println(aa.c);
		aa.c();
	}
}
