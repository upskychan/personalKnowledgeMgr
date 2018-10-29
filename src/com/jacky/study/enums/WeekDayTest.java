package com.jacky.study.enums;


public class WeekDayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(WeekDay day : WeekDay.values()){
			System.out.print(day);
			System.out.print("	");
			System.out.println(day.isWorkDay());
		}
		System.out.println(WeekDay.Monday);
	}

}
