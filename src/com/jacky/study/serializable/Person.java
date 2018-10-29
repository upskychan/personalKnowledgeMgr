package com.jacky.study.serializable;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private Tool tool;

	/**
	 * @return the tool
	 */
	public Tool getTool() {
		return tool;
	}

	/**
	 * @param tool
	 *            the tool to set
	 */
	public void setTool(Tool tool) {
		this.tool = tool;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
