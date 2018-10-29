package com.jacky.study.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferTest {
	static final int LENGTH = 0x8FFFF;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileChannel fc = null;
		try {
			fc = new RandomAccessFile("mappedFile.dat","rw").getChannel();
			MappedByteBuffer mappedBuffer = fc.map(FileChannel.MapMode.READ_WRITE, 1000, LENGTH);
			for(int i=0;i<LENGTH;i++){
				mappedBuffer.put((byte)'X');
			}
//			mappedBuffer.force();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
