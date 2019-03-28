package com.jacky.study.reflect.reflecttest;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 如果不知道某个对象的确切类型，RTTI可以告诉你，但是有一个前提：这个类型在编译时必须已知，这样才能使用RTTI来识别它。
 * Class类与java.lang.reflect类库一起对反射进行了支持，该类库包含Field、Method和Constructor类，这些类的对象由JVM在启动时创建，用以表示未知类里对应的成员。
 * 这样的话就可以使用Contructor创建新的对象，用get()和set()方法获取和修改类中与Field对象关联的字段，用invoke()方法调用与Method对象关联的方法。
 * 另外，还可以调用getFields()、getMethods()和getConstructors()等许多便利的方法，以返回表示字段、方法、以及构造器对象的数组，
 * 这样，对象信息可以在运行时被完全确定下来，而在编译时不需要知道关于类的任何事情.
 * 
 * @author Upsky
 *
 */
public class Person implements Serializable {
	private String name;
	private int age;
	
	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public static void main(String[] args) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
	    Person person = new Person("Jacky", 23);
	    Class clazz = person.getClass();

	    Field[] fields = clazz.getDeclaredFields();
	    for (Field field : fields) {
	        String key = field.getName();
	        PropertyDescriptor descriptor = new PropertyDescriptor(key, clazz);
	        Method method = descriptor.getReadMethod();
	        Object value = method.invoke(person);

	        System.out.println(key + ":" + value);

	    }
	}

}
