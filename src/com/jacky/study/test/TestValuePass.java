package com.jacky.study.test;

/*
	解析：大家可能以为Java中String和数组都是对象所以肯定是对象引用，然后就会选D，其实这是个很大的误区：因为在java里没有引用传递，只有值传递
	这个值指的是实参的地址的拷贝，得到这个拷贝地址后，你可以通过它修改这个地址的内容（引用不变），因为此时这个内容的地址和原地址是同一地址，
	但是你不能改变这个地址本身使其重新引用其它的对象，也就是值传递。
 */
public class TestValuePass {
	String str = new String("good");

	char[] ch = { 'a', 'b', 'c' };

	public static void main(String args[]) {

		TestValuePass vPass = new TestValuePass();

		vPass.change(vPass.str, vPass.ch);

		System.out.print(vPass.str + " and ");

		System.out.print(vPass.ch);

	}

	public void change(String str, char ch[]) {

		str = "test ok";
		ch[0] = 'g';

		// this.str = "test ok";
		// this.ch[0] = 'g';
		// 加上this之后结果会有不一样哦！

	}
}
