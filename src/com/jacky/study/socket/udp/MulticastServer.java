package com.jacky.study.socket.udp;

import java.io.IOException;

public class MulticastServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new MulticastServerThread("MulticastServerThread").start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
