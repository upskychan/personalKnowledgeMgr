package com.jacky.study.test;

public class TestLong {
	public static void main(String[] args) {
		String str=",1,59";
//		String str = ",1,59,60";
//		String value = str.substring(3);
//		int end = value.indexOf(",");
//		if(end > 0){
//			value = value.substring(0, end);
//		}
		int end = str.indexOf(",", 3);
		String value = "";
		if(end > 0){
			value = str.substring(3, end);
		}else{
			value = str.substring(3);
		}
		System.out.println(value);
		Long value1 = 1L;
		Long value2 = 1L;
		Long value3 = 2L;
		long value4 = 1l;
		if(value1.equals(value2)){
			System.out.println("value1.equals(value2)");
		}
		if(value1==value2){
			System.out.println("value1==value2");
		}
		if(value1==value4){
			System.out.println("value1==value4");
		}
		if(value1.equals(value3)){
			System.out.println("value1.equals(value3)");
		}
		if(value1==1){
			System.out.println("value1==1");
		}
	}
}
