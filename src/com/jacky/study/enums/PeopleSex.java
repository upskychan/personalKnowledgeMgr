package com.jacky.study.enums;

public enum PeopleSex {
	male("M"),female("F");
	
	private final String sex;
	
	private PeopleSex(String sex){
		this.sex = sex;
	}
	
	public String getSex(){
		return this.sex;
	}
}
