package com.jacky.study.javainit;

public class Parent {
	static Tipout tipout = new Tipout("父类 static 成员 tipout 初始化");
	long timeout = 1000;
	Tipout tip = new Tipout("父类 成员 tip 初始化");

	public Parent() {
		System.out.println("父类 构造函数 调用");
		timeout = 2000;
	}
	
	public static void main(String[] args) {
//		Parent parent = new Parent();
//		Parent parent_sub = new Sub();
		Sub sub = new Sub();
		System.out.println(sub.timeout);
		/**
		 * 结论：
		 * java初始化的顺序：
		 * 1.所有静态成员初始化（父类->子类）
		 * 2.父类初始化（普通成员->构造函数）
		 * 3.子类初始化（普通成员-->构造函数）
		 */
	}
}

class Sub extends Parent {
	static Tipout subTipout = new Tipout("子类 static 成员 subTipout 初始化");
	Tipout subTip = new Tipout("子类 成员 subTip 初始化");

	public Sub() {
		System.out.println("子类 构造函数 调用");
	}
}

class Tipout {
	public Tipout(String s) {
		System.out.println(s);
	}
}
