package com.jacky.study.nio;

import java.nio.ByteBuffer;

public class BufferTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(16);
		buffer.put((byte)23);
		buffer.put((byte)34);
		System.out.println(buffer);
	}

}
