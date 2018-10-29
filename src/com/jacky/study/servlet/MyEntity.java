package com.jacky.study.servlet;

import java.util.List;
import java.util.Map;

public class MyEntity {
	private String userName;
	private List<Map<String, String>> items;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Map<String, String>> getItems() {
		return items;
	}

	public void setItems(List<Map<String, String>> items) {
		this.items = items;
	}

}
