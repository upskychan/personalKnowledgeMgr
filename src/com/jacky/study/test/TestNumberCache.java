package com.jacky.study.test;

/**
 * 类似Integer、Long等基础类型的对应对象类型都有缓存机制，数值为-128到127的话将会被缓存，具体请看它们的valueOf()方法。 
 * @author chenjie
 * @times 2013-7-24 下午5:37:47
 *
 */
public class TestNumberCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer a = 10;
		Integer b = 10;
		System.out.println(a==b);
		
		Integer c = 128;
		Integer d = 128;
		System.out.println(c==d);
		
		Integer e = new Integer(47);
		Integer f = new Integer(47);
		System.out.println(e==f);
	}

}
