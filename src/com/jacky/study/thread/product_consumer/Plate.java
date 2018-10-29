package com.jacky.study.thread.product_consumer;

import java.util.ArrayList;
import java.util.List;

public class Plate {
	private List<Object> eggs = new ArrayList<Object>();

	public synchronized void putEgg(Object egg) {
		while(eggs.size()>0) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		eggs.add(egg);
		notify();
		System.out.println("放入鸡蛋");
	}

	public synchronized Object getEgg() {
		while(eggs.size()==0) {
			try {
				wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Object egg = eggs.get(0);
		eggs.clear();
		notify();
		System.out.println("拿走鸡蛋");
		return egg;
	}
}
