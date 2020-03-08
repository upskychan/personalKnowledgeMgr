package com.jacky.study.javainit;

import java.util.concurrent.atomic.AtomicInteger;

public class JavaBaseTypeInit {
	//基本类型声明之后分配内存空间并初始化默认值；封装类型和引用类型初始化时默认值为null。
	private static int a;
	private int b;
	private static Integer c;
	private Integer d;
	private static java.util.concurrent.atomic.AtomicInteger e = new AtomicInteger(10);

	private void print() {
		System.out.println("a=" + a);
		System.out.println("b=" + b);
		System.out.println("c=" + c);
		System.out.println("d=" + d);
		System.out.println("e=" + e);
		printFenge();
	}

	private void printFenge() {
		System.out.println("****************************************");
	}

	/**
	 * 基本类型值传递.
	 */
	private void changeA(int copyA) {
		copyA++;
	}

	/**
	 * 基本类型的封装类为地址传递.
	 */
	private void changeC(Integer copyC) {
		System.out.println(System.identityHashCode(copyC));
		copyC = c + 1;//相当于重新创建了一个新对象，然后copyC指向了新对象的地址
		System.out.println(System.identityHashCode(copyC));
		System.out.println(System.identityHashCode(JavaBaseTypeInit.c));//但JavaBaseTypeInit.c仍然指向原对象的地址，所以输出值没变
	}

	/**
	 * 引用类型为地址传递.
	 */
	private void changeE(AtomicInteger copyE) {
		copyE.addAndGet(1);
	}

	public static void main(String[] args) {
		JavaBaseTypeInit javaBaseTypeInit = new JavaBaseTypeInit();
		javaBaseTypeInit.print();
		javaBaseTypeInit.changeA(JavaBaseTypeInit.a);
		javaBaseTypeInit.print();
		JavaBaseTypeInit.c = 10;
		javaBaseTypeInit.changeC(JavaBaseTypeInit.c);
		javaBaseTypeInit.print();
		javaBaseTypeInit.changeE(JavaBaseTypeInit.e);
		javaBaseTypeInit.print();
	}

}
