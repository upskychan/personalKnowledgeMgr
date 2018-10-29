package com.jacky.study.thread;

import java.util.concurrent.atomic.AtomicLong;

public class AddSumThread implements Runnable {

	@Override
	public void run() {
		AtomicLong sum = CacheHolder.getSum();
		for (int i = 0; i < 100; i++) {
			sum.addAndGet(1);
		}
	}
}
