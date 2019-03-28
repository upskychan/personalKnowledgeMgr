package com.jacky.study.reflect.staticinit.test2;

public class Base {
	static int num = 1;

	static {
		System.out.println("Base.static : Base " + num);
	}
	
	public Base(){
		System.out.println("Base类构造方法里");
	}
}
