package com.jacky.study.string;

import com.spreada.utils.chinese.ZHConverter;

public class ZhConverterTest {

	public static void main(String[] args) {
		ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
		String simplifiedStr = converter.convert("有背光的機械式鍵盤");
		System.out.println(simplifiedStr);

		String traditionalStr = ZHConverter.convert("有背光的机械式键盘", ZHConverter.TRADITIONAL);
		System.out.println(traditionalStr);//“机”字未能成功转换
	}

}
