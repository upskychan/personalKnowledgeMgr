package com.jacky.study.thread;

/**
 * T1、T2、T3三个线程，如何保证T1执行完后T2执行，T2执行完后T3执行。
 * Thread.join()：等待这个线程死亡。
 * 
 * @author upsky
 *
 */
public class JoinTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println("T1");
				}
			}

		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					t1.join();//引用T1线程，等待T1执行完。
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 5; i++) {
					System.out.println("T2");
				}
			}

		});
		
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					t2.join();//引用T2线程，等待T2执行完。
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (int i = 0; i < 5; i++) {
					System.out.println("T3");
				}
			}

		});
		
		t1.start();
		t2.start();
		t3.start();
	}
}
