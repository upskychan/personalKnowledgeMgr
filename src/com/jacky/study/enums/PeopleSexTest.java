package com.jacky.study.enums;

import java.util.Calendar;


public class PeopleSexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.GregorianCalendar c = new java.util.GregorianCalendar();
		System.out.println(c.get(Calendar.DATE));
		c.add(5, 2);
		System.out.println(c.get(Calendar.DATE));
		
		for(PeopleSex sex : PeopleSex.values()) {
			System.out.println(sex);
			System.out.println(sex.getSex());
			if("M".equals(sex.getSex())) {
				System.out.println("M is " + sex.name());
			}
		}
		System.out.println(PeopleSex.values().getClass());
	}

}
