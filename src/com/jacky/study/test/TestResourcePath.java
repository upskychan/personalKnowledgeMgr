package com.jacky.study.test;

import java.net.URISyntaxException;

public class TestResourcePath {
	public static void main(String[] args) throws URISyntaxException {
		String path = TestResourcePath.class.getResource("/").toURI().getPath();
		System.out.println(path);
	}
}
