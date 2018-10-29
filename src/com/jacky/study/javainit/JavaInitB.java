package com.jacky.study.javainit;

/*
 * 首先加载主类B，初始化静态成员Y，发现需要类A的信息，于是加载类A，初始化静态成员X，也用到B类信息，
 * 由于此时B类的Y还未成功加载因此这里是默认值0，从而得到A类的X为1，然后返回到B类，得到Y为2。
 */
public class JavaInitB {
	public static int Y = JavaInitA.X + 1;

	static {
	}

	public static void main(String[] args) {
		System.out.println("X = " + JavaInitA.X + ", Y = " + JavaInitB.Y);
	}
}

class JavaInitA {
	public static int X;

	static {
		X = JavaInitB.Y + 1;
	}
}
