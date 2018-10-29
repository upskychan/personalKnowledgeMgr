package com.jacky.study.thread;

import java.util.concurrent.atomic.AtomicLong;

public final class CacheHolder {
	private static Long count = 0L;
	private static AtomicLong sum = new AtomicLong();

	public static AtomicLong getSum() {
		return sum;
	}

	public static void setSum(AtomicLong sum) {
		CacheHolder.sum = sum;
	}

	public static Long getCount() {
		return count;
	}

	public static void setCount(Long count) {
		CacheHolder.count = count;
	}

}
