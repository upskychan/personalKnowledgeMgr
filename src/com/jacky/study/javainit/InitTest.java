package com.jacky.study.javainit;

/**
 * 当未对变量手动初始化时，会有两种情况：1.对于成员变量，会默认一个初始值；2.对于局部变量，会发生编译时错误。
 * 
 * @author chenjie
 * @times 2014-3-5 上午9:36:15
 * 
 */
public class InitTest {
	private static Object a;
	private static int b;
	private static long c;
	private static char d;
	private static float e;
	private static double f;
	private static byte g;
	private static boolean h;
	private static short i;

	public static void main(String[] args) {
		Object p_a;
		int p_b;
		long p_c;
		char p_d;
		float p_e;
		double p_f;
		byte p_g;
		boolean p_h;
		short p_i;

		System.out.println(a);// null
		System.out.println(b);// 0
		System.out.println(c);// 0
		System.out.println(d);// []
		System.out.println(e);// 0.0
		System.out.println(f);// 0.0
		System.out.println(g);// 0
		System.out.println(h);// false
		System.out.println(i);// 0
		System.out
				.println("*************************我是分界线***************************");
		System.out
				.println("****************以下部分代码会发生编译时错误**********************");
		// System.out.println(p_a);
		// System.out.println(p_b);
		// System.out.println(p_c);
		// System.out.println(p_d);
		// System.out.println(p_e);
		// System.out.println(p_f);
		// System.out.println(p_g);
		// System.out.println(p_h);
		// System.out.println(p_i);
	}
}
