package com.jacky.study.thread.product_consumer;

public class Producter implements Runnable {
	private Plate plate;
	private Object egg = new Object();

	public Producter(Plate plate) {
		this.plate = plate;
	}

	@Override
	public void run() {
		while (true) {
			plate.putEgg(egg);
		}
	}

}
