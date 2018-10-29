package com.jacky.study.test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 移位操作.
 * 
 * @author chenjie
 * @times 2014-2-10 上午11:54:13
 * 
 */
public class MoveOperate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// class文件中第7、8位为jdk主版本号
		int jdk1_3 = 0x2F;// 47
		int jdk1_4 = 0x30;// 48
		int jdk1_5 = 0x31;
		int jdk1_6 = 0x32;
		int jdk1_7 = 0x33;// 51
		System.out.println("jdk1.3 : " + jdk1_3);
		System.out.println("jdk1.4 : " + jdk1_4);
		System.out.println("jdk1.5 : " + jdk1_5);
		System.out.println("jdk1.6 : " + jdk1_6);
		System.out.println("jdk1.7 : " + jdk1_7);
		System.out.println("*******************************");

		String b_47 = Integer.toBinaryString(jdk1_3);
		System.out.println(jdk1_3 + ":" + b_47);

		int new_1_3 = jdk1_3 << 8;// 左移8位，右补零，相当于乘以2的8次方
		String b_new_1_3 = Integer.toBinaryString(new_1_3);
		System.out.println(new_1_3 + ":" + b_new_1_3);

		new_1_3 = new_1_3 >> 6;// 右移6位，左边补符号位0，相当于除以2的6次方
		b_new_1_3 = Integer.toBinaryString(new_1_3);
		System.out.println(new_1_3 + ":" + b_new_1_3);

		System.out.println("-47:" + Integer.toBinaryString(-47));
		int t1 = -47 >> 4;// 右移4位，左边补符号位1，丢失精度
		String b_t1 = Integer.toBinaryString(t1);
		System.out.println(t1 + ":" + b_t1);

		int t2 = -47 >>> 4;// 右移4位，不管符号位是0还是1，左边补0，变为正数
		String b_t2 = Integer.toBinaryString(t2);
		System.out.println(t2 + ":" + b_t2);

		System.out.println("*******************************");
		System.out.println(Byte.MAX_VALUE);
		Long l1 = 0xFFFFFFFFL;
		System.out.println(l1);
		System.out.println(Long.toBinaryString(l1));

		// ip地址转化为整数使用的移位计算
		String ip = "202.106.46.151";
		try {
			InetAddress addr = Inet4Address.getByName(ip);
			long ipNum = addr.hashCode() & 0xFFFFFFFFL;
			System.out.println(ip + ":" + ipNum);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		byte b = Byte.valueOf("127");
		System.out.println(b);
	}

}
