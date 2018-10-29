package com.jacky.study.thread.product_consumer;

import org.junit.Test;

public class TestEggs {
	@Test
	public void test1() {
		Plate plate = new Plate();
		new Thread(new Producter(plate)).start();
		new Thread(new Consumer(plate)).start();
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
		}
	}
}
