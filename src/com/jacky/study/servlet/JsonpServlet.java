package com.jacky.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

public class JsonpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/plain");
		response.setContentType("application/json");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		MyEntity myEntity = new MyEntity();
		myEntity.setUserName("Jacky");
		List<Map<String,String>> itemList = new ArrayList<Map<String,String>>();
		for(int i=0;i<10;i++) {
			Map<String,String> item = new HashMap<String,String>();
			item.put("inputValue", new Date()+"");
			itemList.add(item);
		}
		myEntity.setItems(itemList);
		PrintWriter out = response.getWriter();
		JSONObject resultJSON = JSONObject.fromObject(myEntity); // 根据需要拼装json
		String jsonpCallback = request.getParameter("jsoncallback");// 客户端请求参数
		out.println(jsonpCallback + "(" + resultJSON.toString(1, 1) + ")");// 返回jsonp格式数据
		out.flush();
		out.close();
	}

}
