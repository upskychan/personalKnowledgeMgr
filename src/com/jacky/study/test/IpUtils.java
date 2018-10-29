package com.jacky.study.test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * IP地址转换工具类.
 * 
 * @author xulizhong@myce.net.cn
 * @Time 2007-12-26 上午09:36:16
 */
public final class IpUtils {
	/**
	 * private构造函数.
	 */
	private IpUtils() {
	}

	public static final String IP_SP = "\\.";

	/**
	 * IP地址字符串转换为整数, 以便比较.
	 * 
	 * @param ip
	 *            '.'分隔的字符串
	 * @return long
	 * 
	 */
	public static long convertIpv4(final String ip) {
		if (null == ip) {
			throw new NullPointerException();
		}

		try {
			InetAddress addr = Inet4Address.getByName(ip);
			return addr.hashCode() & 0xFFFFFFFFL;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return -1;
	}

	/**
	 * 整数转换为IP地址字符串.
	 * 
	 * @param num
	 *            整数
	 * @return IP地址字符串.
	 */
	public static String convertNum(final long num) {
		StringBuilder sbd = new StringBuilder();
		int len = 4;
		for (int i = 0; i < len; i++) {
			if (i != 0) {
				sbd.append('.');
			}
			sbd.append(getByte(num, len - i - 1));
		}
		return sbd.toString();
	}

	/**
	 * 获得指定字节.
	 * 
	 * @param v
	 *            long
	 * @param x
	 *            xth begin with 0
	 * @return xth byte value
	 */
	private static int getByte(final long v, final int x) {
		int bits = 8 * x;
		return (int) (((v & (0xFF << bits)) >>> bits) & 0xFFL);
	}
}
