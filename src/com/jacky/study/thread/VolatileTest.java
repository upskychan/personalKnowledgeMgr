package com.jacky.study.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
	public static int count = 0;
//	public volatile static int count2 = 0;
	public volatile static AtomicInteger count2 = new AtomicInteger();

	public static void inc() {
		// 这里延迟1毫秒，使得结果明显
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}

		count++;
	}

	public static void t1() {
		// 同时启动1000个线程，去进行i++计算，看看实际结果

		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					VolatileTest.inc();
				}
			}).start();
		}

		// 这里每次运行的值都有可能不同,可能为1000
		System.out.println("运行结果:Counter.count=" + VolatileTest.count);
		// 实际运算结果每次可能都不一样，本机的结果为：运行结果:Counter.count=995，可以看出，在多线程的环境下，Counter.count并没有期望结果是1000
		// 很多人以为，这个是多线程并发问题，只需要在变量count之前加上volatile就可以避免这个问题.
	}

	public static void inc2() {

		// 这里延迟1毫秒，使得结果明显
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}

//		count2++;
		count2.incrementAndGet();
	}

	public static void t2() {
		// 同时启动1000个线程，去进行i++计算，看看实际结果

		for (int i = 0; i < 1000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					VolatileTest.inc2();
				}
			}).start();
		}

		// 这里每次运行的值都有可能不同,可能为1000
		System.out.println("运行结果:Counter.count2=" + VolatileTest.count2);
		//运行结果:Counter.count2=978
		//运行结果还是没有我们期望的1000
	}

	public static void main(String[] args) {
		// t1();
		t2();
	}

}
