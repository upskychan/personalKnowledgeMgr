package com.jacky.study.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Date;

public class MulticastServerThread extends Thread {
	private final static long SLEEPTIME = 30000;
	private MulticastSocket socket = null;

	public MulticastServerThread(String name) throws IOException {
		super(name);
		socket = new MulticastSocket(1203);
	}

	public void run() {
		boolean needSend = true;
		try {
			InetAddress group = InetAddress.getByName("230.0.0.1");
			while (needSend) {
				try {
					Thread.sleep(SLEEPTIME);
				} catch (Exception e) {
					e.printStackTrace();
				}
				String sendString = new Date().toString();
				sendString = "ÏûÏ¢" + sendString;
				byte[] buffer = sendString.getBytes();
				DatagramPacket packet = new DatagramPacket(buffer,
						buffer.length, group, 1203);
				socket.send(packet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		socket.close();
	}
}
