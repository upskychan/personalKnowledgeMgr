package com.jacky.study.number;

import java.text.DecimalFormat;

public class TestDecimalFormat {

	public static void main(String[] args) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		System.out.println(decimalFormat.format(12.99438483f));
	}

}
