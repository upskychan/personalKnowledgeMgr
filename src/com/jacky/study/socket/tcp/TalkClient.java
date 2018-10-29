package com.jacky.study.socket.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",1203);
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String readLine = input.readLine();
			while(!readLine.equals("bye")){
				os.println(readLine);
				os.flush();
				System.out.println("Client:"+readLine);
				System.out.println("Server:"+is.readLine());
				readLine = input.readLine();
			}
			os.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
