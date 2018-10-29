package com.jacky.study.thread;

import java.util.Date;

public class PrintRunThread implements Runnable {
	private String threadName;

	public PrintRunThread(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(threadName + ":" + new Date());
	}

	public String getThreadName() {
		return threadName;
	}

}
