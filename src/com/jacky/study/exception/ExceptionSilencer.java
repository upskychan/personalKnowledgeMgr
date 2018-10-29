package com.jacky.study.exception;

/**
 * 异常丢失。当在finally中返回时，即使抛出了异常，它也不会产生任何输出。
 * 
 * @author chenjie
 * @times 2014-2-25 上午9:11:48
 * 
 */
public class ExceptionSilencer {
	public static void main(String[] args) {
		try {
			throw new RuntimeException();
		} finally {
			return;
		}
	}
}
