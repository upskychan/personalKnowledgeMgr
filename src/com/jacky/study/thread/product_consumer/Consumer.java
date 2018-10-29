package com.jacky.study.thread.product_consumer;

public class Consumer implements Runnable {
	private Plate plate;

	public Consumer(Plate plate) {
		this.plate = plate;
	}

	@Override
	public void run() {
		while (true) {
			plate.getEgg();
		}
	}

}
