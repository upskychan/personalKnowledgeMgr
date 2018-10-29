package com.jacky.study.thread;

import org.junit.Test;

public class ThreadTest {
	public void test1() {
		PrintRunThread r1 = new PrintRunThread("T1");
		Thread t1 = new Thread(r1);
		t1.setName(r1.getThreadName());
		t1.start();
	}

	public void test2() {
		for (int i = 0; i < 100000; i++) {
			String threadName = "T_" + i;
			PrintRunThread r1 = new PrintRunThread(threadName);
			Thread t1 = new Thread(r1);
			t1.setName(r1.getThreadName());
			t1.start();
		}
	}

	public void test3() {
		for (int i = 0; i < 100000; i++) {
			String threadName = "T_" + i;
			PrintRunThread r1 = new PrintRunThread(threadName);
			Thread t1 = new Thread(r1);
			t1.setName(r1.getThreadName());
			t1.start();
		}

		for (int i = 0; i < 100000; i++) {
			String threadName = "S_" + i;
			PrintThread t1 = new PrintThread(threadName);
			t1.start();
		}
	}

	@Test
	public void test4() {
		for (int i = 0; i < 100; i++) {
			AddCountThread r1 = new AddCountThread();
			Thread t1 = new Thread(r1);
			t1.start();
		}
		while(true) {
			System.out.println(CacheHolder.getCount()); // 9657
			// 结果并不必然等于10000，线程不安全，会有多线程同时操作CacheHolder的count变量
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
			}
		}
	}
	
	public void test5() {
		for (int i = 0; i < 100; i++) {
			AddSumThread r1 = new AddSumThread();
			Thread t1 = new Thread(r1);
			t1.start();
		}
		while(true) {
			System.out.println(CacheHolder.getSum()); // 10000
			// AtomicLong为线程安全的，即使多个线程同时访问sum，其运算操作也是原子的
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
			}
		}
	}
}
