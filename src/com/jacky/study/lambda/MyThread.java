package com.jacky.study.lambda;

/**
 * 使用() -> {} 替代匿名类.
 * @author Upsky
 *
 */
public class MyThread {
	public static void main(String[] args) {
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				System.out.println("New Thread Before Java8!");
//			}
//			
//		}).start();
		
		new Thread( () -> System.out.println("New Thread In Java8!")).start();
	}
}
