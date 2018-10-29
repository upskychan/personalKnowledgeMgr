package com.jacky.study.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestTimes {
	public static void main(String[] args) {
		try {
			Calendar calendar = Calendar.getInstance();
			System.out.println(calendar);
			
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//			Date date = sf.parse("2013-09-03");
			Date date = sf.parse("1713-09-03");
			System.out.println(date.getTime());
			System.out.println(date.toLocaleString());
			
			//1378137600000
			
			Date date2 = new Date(1378137600000L);
			System.out.println(date2);
			
			Date date3 = new Date(1357833600000L);
			System.out.println(date3);
			
			Timestamp times = new Timestamp(1383188541107L);
			System.out.println(times);
			
			Timestamp times2 = new Timestamp(1383204178530L);
			System.out.println(times2);
			
			Date now = new Date();
			System.out.print("Date now = new Date(); : ");
			System.out.println(now.toLocaleString());
			
			Date stDate = new Date(0);
			System.out.print("Date stDate = new Date(0); : ");
			System.out.println(stDate.toLocaleString());
			
			Date oldDate = new Date(-8088969600000L);
			System.out.print("Date oldDate = new Date(-1383188541107L); : ");
			System.out.println(stDate.toLocaleString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
