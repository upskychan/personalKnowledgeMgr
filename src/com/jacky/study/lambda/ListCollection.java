package com.jacky.study.lambda;

import java.util.Arrays;
import java.util.List;

public class ListCollection {
	public static void main(String[] args) {
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for (String feature : features) {
			System.out.println(feature);
		}
		
		System.out.println("****************************");
		
		features.forEach(feature -> System.out.println(feature));
		features.forEach(feature -> System.out.println(feature.getBytes()));
		features.forEach(System.out::println);
	}
}
