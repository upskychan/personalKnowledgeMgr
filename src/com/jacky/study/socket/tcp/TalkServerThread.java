package com.jacky.study.socket.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkServerThread extends Thread {
	private Socket socket = null;
	private int num = 0;
	public TalkServerThread(Socket socket,int num){
		this.socket = socket;
		this.num = num;
	}
	
	public void run(){
		try {
			String message;
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader is = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			PrintWriter os = new PrintWriter(this.socket.getOutputStream());
			System.out.println("Client" + num +" to Server:"+is.readLine());
			message = input.readLine();
			while(!message.equals("bye")){
				os.println(message);
				os.flush();
				System.out.println("Server:"+" to Client"+num+":"+message);
				System.out.println("Client:" + num +" to Server:"+is.readLine());
				message = input.readLine();
			}
			os.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
