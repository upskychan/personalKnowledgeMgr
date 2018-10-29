package com.jacky.study.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class TestUUID {
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			System.out.println(UUID.randomUUID().toString());
			Date time = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmssSSS");
			System.out.println(format.format(time));
		}
		System.out.println(UUID.randomUUID().variant());
		
		System.out.println(System.getProperty("caltype", "common"));
	}
}
