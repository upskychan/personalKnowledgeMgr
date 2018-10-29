package com.jacky.study.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {
	private static byte[] buf = new byte[256];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MulticastSocket socket = new MulticastSocket(1203);
			InetAddress group = InetAddress.getByName("230.0.0.1");
			socket.joinGroup(group);
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			boolean needRead = true;
			while (needRead) {
				socket.receive(packet);
				int length = packet.getLength();
				byte[] value = new byte[length];
				byte[] data = packet.getData();
				for (int i = 0; i < length; i++) {
					value[i] = data[i];
				}
				String receiveData = new String(value);
				System.out.println("Receive:" + receiveData);
			}
			socket.leaveGroup(group);
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
