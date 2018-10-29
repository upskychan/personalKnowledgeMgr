package com.jacky.study.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Writer;

public class IOTest {

	public static void writeByRandomAccess() {
		String fileName = "D:" + File.separator + "writebyrandom.txt";
		File file = new File(fileName);
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			raf.writeChars("aaaaaa");
			raf.writeChars("中国北京");
			raf.writeChars("\n");
			raf.writeLong(1341243L);
			raf.write("abcde".getBytes());
			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeByOutputstream() {
		String fileName = "D:" + File.separator + "writebyops.txt";
		File file = new File(fileName);
		try {
			OutputStream ops = new FileOutputStream(file);
			ops.write("中国北京".getBytes());
			ops.write("\r\n".getBytes());
			// ops.write(234);
			ops.write("介绍".getBytes());
			ops.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readByFileinputstream() {
		String fileName = "D:" + File.separator + "writebyops.txt";
		File file = new File(fileName);
		try {
			InputStream fis = new FileInputStream(file);
			byte[] read = new byte[1024];
			int len = fis.read(read);
			fis.close();
			System.out.println(new String(read, 0, len));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readByFileinputstream2() {
		String fileName = "D:" + File.separator + "writebyops.txt";
		File file = new File(fileName);
		try {
			InputStream fis = new FileInputStream(file);
			byte[] read = new byte[1024];
			int count = 0;
			int temp = 0;
			while ((temp = fis.read()) != (-1)) {
				read[count++] = (byte) temp;
			}
			fis.close();
			System.out.println(new String(read, 0, count));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void writeByFilewriter() {
		String fileName = "D:" + File.separator + "writebyfilewriter.txt";
		File file = new File(fileName);
		try {
			Writer fw = new FileWriter(file);
			fw.write("中北");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// writeByRandomAccess();
		// writeByOutputstream();
		// readByFileinputstream();
		// readByFileinputstream2();
		writeByFilewriter();
	}

}
