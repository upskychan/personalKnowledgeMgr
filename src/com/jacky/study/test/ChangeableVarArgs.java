package com.jacky.study.test;

public class ChangeableVarArgs {

	public static void f(int required, String... trailing) {
		System.out.println("required:" + required);
		for (String str : trailing) {
			System.out.print(str + " ");
		}
		System.out.println();
	}

	public static void f(int required, String trailing) {
		System.out.println("required:" + required);
		System.out.println("not change:" + trailing);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		f(1, "a");
		f(2, "a", "b");
		f(0);
	}

}
