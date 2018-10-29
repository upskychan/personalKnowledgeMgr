package com.jacky.study.socket.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Blob;
import java.sql.PreparedStatement;

import javax.sql.rowset.serial.SerialBlob;

public class TalkServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			ServerSocket server = null;
			try {
				server = new ServerSocket(1203);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Socket socket = null;
			try {
				socket = server.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String message;
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			System.out.println("Client:"+is.readLine());
			message = input.readLine();
			while(!message.equals("bye")){
				os.println(message);
				os.flush();
				System.out.println("Server:"+message);
				System.out.println("Client:"+is.readLine());
				message = input.readLine();
			}
			os.close();
			is.close();
			socket.close();
			server.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
