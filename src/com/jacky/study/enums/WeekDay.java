package com.jacky.study.enums;

public enum WeekDay {
	Monday(1){
		public boolean isWorkDay(){
			return true;
		}
	},
	Sunday(7){
		public boolean isWorkDay(){
			return false;
		}
	};
	
	private final int day;
	
	WeekDay(int day){
		this.day = day;
	}
	
	public int getDay(){
		return this.day;
	}
	
	public abstract boolean isWorkDay();
}
