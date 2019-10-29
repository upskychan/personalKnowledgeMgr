package com.jacky.study.lambda;

import java.util.HashMap;
import java.util.Map;

public class ListMap {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 30);
		map.put("D", 40);
		map.put("E", 50);

		map.forEach((key, value) -> System.out.println("key:" + key + "--value:" + value));
	}
}
