package com.jacky.study.depthclone;

/**
 * 使用Cloneable接口的clone()方法实现深度克隆，
 * 其中要注意Acount类中clone方法的写法，同时User类也需要实现Cloneable接口.
 * 
 * @author chenjie@shihua.com.cn
 * @times 2011-12-9 下午05:16:34
 * 
 */
public class DepthCloneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			User user = new User();
			user.setAge(20);
			user.setUserName("Jacky");
			Acount acount = new Acount();
			acount.setUser(user);
			acount.setBalance(10000);
			System.out.println("acount:" + acount);
			System.out.println("acount.user:" + acount.getUser());
			Acount acCopy = acount.clone();
			System.out.println("acCopy:" + acCopy);
			System.out.println("acCopy.user:" + acCopy.getUser());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
