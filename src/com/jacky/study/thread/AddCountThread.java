package com.jacky.study.thread;

public class AddCountThread implements Runnable {

	@Override
	public void run() {
		Long count = CacheHolder.getCount();
		for (int i = 0; i < 100; i++) {
			count++;
			CacheHolder.setCount(count);
		}
		
//		synchronized(this){ // 不能锁住
//			Long count = CacheHolder.getCount();
//			for (int i = 0; i < 100; i++) {
//				count++;
//				CacheHolder.setCount(count);
//			}
//		}
		
//		synchronized(AddCountThread.class){ // 可以锁住
//			Long count = CacheHolder.getCount();
//			for (int i = 0; i < 100; i++) {
//				count++;
//				CacheHolder.setCount(count);
//			}
//		}
	}

}
