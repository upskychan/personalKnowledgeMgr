package com.jacky.study.lambda;

import java.util.Optional;

public class OptionalTest {
	public static void main(String[] args) {
		Optional<String> optional = Optional.of("Jerry");
		System.out.println(optional.isPresent());
		System.out.println(optional.get());
		System.out.println(optional.orElse("无值"));
		optional.ifPresent((s)-> System.out.println(s.charAt(0)));
	}
}
