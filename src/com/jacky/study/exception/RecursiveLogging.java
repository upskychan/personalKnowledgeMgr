package com.jacky.study.exception;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.apache.log4j.Logger;

/**
 * 将System.out重定向到log4j.
 * 
 * @author chenjie
 * @times 2014-2-18 上午11:10:36
 * 
 */
public class RecursiveLogging {
	public static void main(String[] args) {
		System.setOut(new PrintStream(new CustomOutputStream()));
		
		TestMyException.testPrint();
	}

}

class CustomOutputStream extends OutputStream {
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public final void write(int b) throws IOException {
		// the correct way of doing this would be using a buffer
		// to store characters until a newline is encountered,
		// this implementation is for illustration only
		logger.info((char) b);
	}

	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		if (b == null) {
            throw new NullPointerException();
        } else if ((off < 0) || (off > b.length) || (len < 0) ||
                   ((off + len) > b.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }
		byte[] pb = new byte[len];
        for (int i = 0 ; i < len ; i++) {
        	pb[i] = (b[off + i]);
        }
        String str = new String(pb);
        logger.info(str);
	}
}
