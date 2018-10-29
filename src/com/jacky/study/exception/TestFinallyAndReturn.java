package com.jacky.study.exception;

/**
 * 一、Java中异常捕获机制try...catch...finally块中的finally语句是不是一定会被执行？
 * 很多人都说不是，当然他们的回答是正确的，经过我试验，至少有两种情况下finally语句是不会被执行的：
 * （1）try语句没有被执行到，如在try语句之前就返回了，这样finally语句就不会执行，这也说明了finally语句被执行的必要而非充分条件是：
 * 相应的try语句一定被执行到。
 * （2）在try块中有System.exit(0);这样的语句，System.exit(0);是终止Java虚拟机JVM的，连JVM都停止了，所有都结束了，
 * 当然finally语句也不会被执行到。
 * 
 * 二、finally语句和return语句的关系呢？
 * finally块的语句在try或catch中的return语句执行之后返回之前执行；且在finally里的修改语句可能影响 也可能不影响try或catch中
 * return已经确定的返回值；若finally里也有return语句则覆盖try或catch中的return语句直接返回。
 *
 */

public class TestFinallyAndReturn {
	public static void main(String[] args) {
		System.out.println(test());
	}

	public static int test() {
		int b = 20;
		try {
			System.out.println("try block");
			return b += 80;// 执行finally语句块之前执行了，但是并没有返回
		} catch (Exception e) {
			System.out.println("catch block");
		} finally {
			System.out.println("finally block");
			if (b > 25) {
				System.out.println("b>25, b=" + b);
			}
			return 200;// 最终返回的却是这个
		}
		// return b;
	}

}
