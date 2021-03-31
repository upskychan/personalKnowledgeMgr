package com.jacky.study.string;

import java.util.Date;

public class StringFormat {
	public static void main(String[] args) {
		String str = null;
		str = String.format("Hi,%s %s,%s%s", "Jacky", "Chan", "你", "好！");
		System.out.println(str);
		System.out.printf("格式化数字：%04d%n", 12);// 数字前面补0，共4位
		System.out.printf("100的16进制数是：%x %n", 100);
		System.out.printf("100的8进制数是：%o %n", 100);
		System.out.printf("50元的书打8.5折扣是：%f 元%n", 50 * 0.85);
		System.out.printf("上面价格的16进制数是：%a %n", 50 * 0.85);
		System.out.printf("上面价格的指数表示：%e %n", 50 * 0.85);
		System.out.printf("字母A的散列码是：%h %n", 'A');
		System.out.printf("一般显示金额的格式：%,f %n", 12345.6789); // 以“,”对数字分组
		Date now = new Date();
		// c的使用
		System.out.printf("全部日期和时间信息：%tc%n", now);
		// f的使用
		System.out.printf("年-月-日格式：%tF%n", now);
		// d的使用
		System.out.printf("月/日/年格式：%tD%n", now);
		// r的使用
		System.out.printf("HH:MM:SS PM格式（12时制）：%tr%n", now);
		// t的使用
		System.out.printf("HH:MM:SS格式（24时制）：%tT%n", now);
		// R的使用
		System.out.printf("HH:MM格式（24时制）：%tR", now);
	}
}
