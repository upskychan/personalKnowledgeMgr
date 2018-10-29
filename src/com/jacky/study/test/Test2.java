package com.jacky.study.test;

import java.math.BigDecimal;

public class Test2 {
	
	public static double scaleByPowerOfTen(double num, int n) {
		double cloneNum = num;
		if (n >= 0) {
			for (int i = 0; i < n; i++) {
				cloneNum *= 10;
			}
			return cloneNum;
		}
		cloneNum = Math.abs(num);
		String strvalue = cloneNum + "";
		long intvalue = (long) cloneNum;
		double floatpart = cloneNum - intvalue;
		int decimalbit = ("" + floatpart).indexOf('.');
		String floatstr = ("" + floatpart).substring(decimalbit);
		strvalue = intvalue + floatstr;
		int prefloatbit = strvalue.length() - strvalue.indexOf('.') - 1;
		// 整数部分长度
		int intLength = ("" + intvalue).length();
		// 需要增加的0的个数
		int insertZeroNum = Math.abs(n) - intLength;
		boolean needInsertZero = insertZeroNum >= 0;
		if (insertZeroNum < 0) {
			insertZeroNum = 0;
		}
		strvalue = strvalue.replaceAll("\\.", "");
		int length = strvalue.length();
		for (int i = 0; i < insertZeroNum; i++) {
			strvalue = "0" + strvalue;
		}
		if (needInsertZero) {
			strvalue = "0." + strvalue;
			cloneNum = Double.parseDouble(strvalue);
		} else {
			String copystr = "";
			// 总共需要的小数位数
			int floatbits = prefloatbit + Math.abs(n);
			for (int i = length - 1; i >= 0; i--) {
				// 到达小数位数后添加小数点
				if (floatbits == copystr.length()) {
					copystr = "." + copystr;
				}
				copystr = strvalue.charAt(i) + copystr;
			}
			cloneNum = Double.parseDouble(copystr);
		}
		if (num < 0) {
			return 0 - cloneNum;
		}
		return cloneNum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigDecimal bd = new BigDecimal("12.3547");
		System.out.println(bd.scale());
		bd.setScale(4);
		bd = bd.scaleByPowerOfTen(-2);
		System.out.println(bd);
		double value = Test2.scaleByPowerOfTen(12.3547, -2);
		System.out.println(value);
	}

}
