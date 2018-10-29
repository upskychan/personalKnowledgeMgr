package com.jacky.study.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Java���л����ɽ����������紫����ߴ洢.
 * ���ж����Լ��Ӷ�����Ҫʵ��Serializable�ӿ�.
 * 
 * @author chenjie@shihua.com.cn
 * @times 2011-12-9 ����05:15:09
 * 
 */
public class SerializeToFlatFile {
	public static void main(String[] args) {
		SerializeToFlatFile ser = new SerializeToFlatFile();
		ser.savePerson();
		ser.restorePerson();
	}

	public void savePerson() {
		Tool tool = new Tool();
		tool.setToolName("Jacky's tool");
		Person myPerson = new Person();
		myPerson.setAge(20);
		myPerson.setName("Jacky");
		myPerson.setTool(tool);
		try {
			FileOutputStream fos = new FileOutputStream("myPerson.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(myPerson);
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void restorePerson() {
		try {
			FileInputStream fis = new FileInputStream("myPerson.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			Person myPerson = (Person) ois.readObject();
			System.out.println("\n--------------------\n");
			System.out.println("Name is: " + myPerson.getName());
			System.out.println("Age is: " + myPerson.getAge());
			System.out.println("Tool is: " + myPerson.getTool().getToolName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
