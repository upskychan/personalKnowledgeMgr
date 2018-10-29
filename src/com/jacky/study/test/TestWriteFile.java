package com.jacky.study.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestWriteFile {
	private static final String DIR = "D:\\";
	private static final String path = "reindex";
	private static final char SPLIT = 0x01;
	private static final String LINE = "\r\n";

	public static void main(String[] args) {
		File dir = new File(DIR + path);
		dir.mkdirs();
		StringBuffer sb = new StringBuffer();
		OutputStream os = null;
		String id = "123";
		for (int i = 0; i < 10; i++) {
			sb.append((int) (Math.random() * 100));
			sb.append(SPLIT);
			sb.append(Math.random());
			sb.append(LINE);
		}
		try {
			os = new FileOutputStream(dir.getAbsolutePath() + File.separator
					+ id);
			os.write(sb.toString().getBytes("utf-8"));
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
