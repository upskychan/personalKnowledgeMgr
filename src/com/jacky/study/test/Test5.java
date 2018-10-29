package com.jacky.study.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Test5 {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sf.setTimeZone(TimeZone.getTimeZone("Asia/shanghai"));
        String str3 = "1927-12-31 23:54:07";
        String str4 = "1927-12-31 23:54:08";
        Date sDt3 = sf.parse(str3);
        Date sDt4 = sf.parse(str4);
        long ld3 = sDt3.getTime() /1000;
        long ld4 = sDt4.getTime() /1000;
        System.out.println(ld3);
        System.out.println(ld4);
        System.out.println(ld4-ld3);

        long time = System.currentTimeMillis();
		time = time / 1000 * 1000 + 2;
		System.out.println(time);
		
		String str = "1,2,3,";
		String[] arr = str.split("[,]");
		System.out.println(arr);
	}

}
