package com.jacky.study.string;

/**
 * 在toString()方法中不要单独使用this关键字，否则会产生递归调用.
 * 
 * @author chenjie
 * @times 2014-2-27 上午10:51:06
 * 
 */
public class DonotUseThisInTostring {
	public static void main(String[] args) {
		Monkey monkey = new Monkey();
		monkey.setName("Jacky");
		System.out.println(monkey);

	}
}

class Monkey {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// return super.toString();
		/*
		 * 编译器看到String后面跟着一个“+”，而再后面的对象不是String时，于是编译器试着将这个对象转换成String类型（
		 * 调用该对象的toString()方法），所以当后面跟的是this关键字时，编译器调用this的toString()，于是就发生了递归调用。
		 */
		// return this.name + "@" + this;
		return this.name + "@" + super.toString();// 应该使用super.toString()
	}

}
