package com.jacky.study.exception;

import java.io.IOException;

/**
 * 异常处理系统会按照代码的书写顺序匹配“最近”的处理程序，找到匹配的异常处理后，它就认为异常得到了处理，然后就不再继续查找。
 * 
 * @author chenjie
 * @times 2014-2-25 上午10:05:55
 * 
 */
public class ExceptionMatch {
	public static void f() throws IOException {
		throw new IOException("我也不知道是什么IO出了问题");
	}

	public static void main(String[] args) {
		try {
			try {
				f();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("inner 1");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("inner 2");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("outer");
		}
	}
}
