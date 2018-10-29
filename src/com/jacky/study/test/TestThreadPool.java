package com.jacky.study.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class TestThreadPool {
	private static ScheduledExecutorService xmlGenExecutor = Executors.newScheduledThreadPool(5);
	private static ExecutorService xmlGenExecutor2 = Executors.newSingleThreadExecutor();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<1000;i++){
			Runnable runnable = new Runnable() {
				public void run() {
					try {
						System.out.println(Thread.currentThread().getName());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
//			xmlGenExecutor.execute(runnable);
			xmlGenExecutor2.execute(runnable);
		}

	}

}
