package com.jacky.study.socket.tcp;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkServer {
	
	private static boolean listening = true;
	private static int clientNum = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		String aaa = new String("aaa");
		list.add(aaa);
		String aa = new String("aaa");
		if(aaa==aa){
			System.out.println("true");
		}
		if(list.contains(aa)){
			System.out.println("true");
		}
		try{
			ServerSocket server = null;
			try {
				server = new ServerSocket(1203);
			} catch (Exception e) {
				e.printStackTrace();
			}
			while(listening){
				try {
					Socket client = server.accept();
					new TalkServerThread(client,clientNum).start();
					clientNum++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			server.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
