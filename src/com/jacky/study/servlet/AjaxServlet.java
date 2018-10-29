package com.jacky.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;html;charset=utf-8");
		String userName = request.getParameter("userName");
		String responseText = new String((userName + "，Get 你妹啊！").getBytes(),"ISO-8859-1");
//		userName=new String(userName.getBytes("ISO-8859-1"),"UTF-8");
//		response.getWriter().write(userName + "，Get 你妹啊！");
		response.getOutputStream().print(responseText);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text;html;charset=utf-8");
		String userName = request.getParameter("userName");
		String responseText = new String((userName + "，Post 你妹啊！").getBytes(),"ISO-8859-1");
//		userName=new String(userName.getBytes("ISO-8859-1"),"UTF-8");
		PrintWriter out = response.getWriter();
		out.println(responseText);
//		response.getWriter().write(responseText);
		out.flush();
		out.close();
	}

}
