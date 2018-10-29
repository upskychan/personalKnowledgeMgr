package com.jacky.study.google.fqueue;

import java.util.Date;

import com.google.code.fqueue.FQueue;

public final class MyQueue {
	private static FQueue queue;
	public static final int SIZE = 1024 * 1024 * 50;
	static {
		try {
			queue = new FQueue("D://myqueue", SIZE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static final FQueue getQueue() {
		return queue;
	}
	
	public static void clear() {
		queue.clear();
	}
	
	public static void main(String[] args) {
		FQueue queue = MyQueue.getQueue();
//		queue.add((new Date() + "").getBytes());
		queue.offer((new Date() + "").getBytes());
		System.out.println(queue.size());
//		System.out.println(queue.peek());
//		System.out.println(queue.size());
		System.out.println(new String(queue.poll()));
	}
}
