package com.jacky.study.test;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestHash {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 10; i++) {
			String key = new Date() + "" + (int) (Math.random() * 10);
			String value = new Date() + "" + (int) (Math.random() * 10);
			int hashcode = key.hashCode();
			map.put(key, value);
		}
		System.out.println(map);

		Object obj = new Object();
		System.out.println(obj.hashCode());// hashCode=798740
		Object obj2 = new Object();
		System.out.println(obj2.hashCode());// hashCode=2661678
		// obj的hashCode不等于obj2的hashCode

		Long long1 = Long.valueOf("10");
		Long long2 = Long.valueOf("10");
		Long long3 = new Long(10);
		System.out.println(long1.hashCode());// hashCode=10
		System.out.println(long2.hashCode());// hashCode=10
		System.out.println(long3.hashCode());// hashCode=10
		System.out.println(long1.equals(long2));// true
		System.out.println(long1.equals(long3));// true
		System.out.println(long1 == long2);// true
		System.out.println(long1 == long3);// false
		long1++;
		System.out.println(long1);// 11
		System.out.println(long2);// 10

		String s1 = new String("zhangsan");
		String s2 = new String("zhangsan");
		System.out.println(s1 == s2);// false
		System.out.println(s1.equals(s2));// true
		System.out.println(s1.hashCode());// s1.hashcode()等于s2.hashcode()
		System.out.println(s2.hashCode());
		Set<String> hashset = new HashSet<String>();
		hashset.add(s1);
		hashset.add(s2);
		System.out.println(hashset);// [zhangsan]，只有一个元素，另外一个被覆盖了

		HashSet<Student> hs = new HashSet<Student>();
		hs.add(new Student(1, "zhangsan"));
		hs.add(new Student(2, "lisi"));
		hs.add(new Student(3, "wangwu"));
		hs.add(new Student(1, "zhangsan"));
		System.out.println(hs);
		// [3:wangwu, 1:zhangsan, 2:lisi,1:zhangsan]。
		// 两个1:zhangsan，因为Object类的本地方法hashCode()得到两个不同的哈希值。
	}

}

class Student {
	int num;
	String name;

	public Student(int num, String name) {
		this.num = num;
		this.name = name;
	}

	public String toString() {
		return num + ":" + name;
	}

	public int hashCode() {
		return num * name.hashCode();
	}

	public boolean equals(Object o) {
		Student s = (Student) o;
		return num == s.num && name.equals(s.name);
	}
}
