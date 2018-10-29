package com.jacky.study.depthclone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.jacky.study.serializable.Person;
import com.jacky.study.serializable.Tool;

/**
 * ʹ��java�����л���ʵ����ȿ�¡�����ж����Լ��Ӷ�����Ҫʵ��Serializable�ӿ�.
 * 
 * @author chenjie@shihua.com.cn
 * @times 2011-12-9 ����05:14:30
 * 
 */
public class DeepCloneUseSerialize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tool tool = new Tool();
		tool.setToolName("Jacky's tool");
		Person myPerson = new Person();
		myPerson.setAge(20);
		myPerson.setName("Jacky");
		myPerson.setTool(tool);
		Person copy = (Person) deepClone(myPerson);
		System.out.println("myPerson:" + myPerson);
		System.out.println("myPerson.tool:" + myPerson.getTool());
		System.out.println("copy:" + copy);
		System.out.println("copy:" + copy.getTool());
	}

	public static Object deepClone(Object src) {
		Object dst = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream oo = new ObjectOutputStream(out);
			oo.writeObject(src);
			ByteArrayInputStream in = new ByteArrayInputStream(
					out.toByteArray());
			ObjectInputStream oi = new ObjectInputStream(in);
			dst = oi.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dst;
	}

}
