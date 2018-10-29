package com.jacky.study.depthclone;

/**
 * ʹ��Cloneable�ӿڵ�clone()����ʵ����ȿ�¡��
 * ����Ҫע��Acount����clone������д����ͬʱUser��Ҳ��Ҫʵ��Cloneable�ӿ�.
 * 
 * @author chenjie@shihua.com.cn
 * @times 2011-12-9 ����05:16:34
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
