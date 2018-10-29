package com.jacky.study.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 使用Servlet实现文件下载.
 */
@WebServlet(name = "DownloadImgServlet", urlPatterns = { "/download" })
// Servlet3.0的注释方式，web.xml里面什么都没有.
public class DownLoadImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*******************");
		String filePath = this.getServletContext().getRealPath("/");// 获取真实路径
		String downloadFilename = "中文也可以.jpg";// 在下载框默认显示的文件名
		downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");
		// 对默认下载的文件名编码。不编码的结果就是，在客户端下载时文件名乱码
		File file = new File(filePath + File.separator + "xxzgxz.jpg");
		if (file.exists()) {
			// 写明要下载的文件的大小
			response.setContentLength((int) file.length());
			response.setHeader("Content-Disposition", "attachment;filename="
					+ downloadFilename);// 设置在下载框默认显示的文件名
			response.setContentType("application/octet-stream");// 指明response的返回对象是文件流
			// 读出文件到response
			// 这里是先需要把要把文件内容先读到缓冲区
			// 再把缓冲区的内容写到response的输出流供用户下载
			FileInputStream fileInputStream = new FileInputStream(file);
			BufferedInputStream bufferedInputStream = new BufferedInputStream(
					fileInputStream);
			byte[] b = new byte[bufferedInputStream.available()];
			bufferedInputStream.read(b);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(b);
			// 人走带门
			bufferedInputStream.close();
			outputStream.flush();
			outputStream.close();
		}
	}

}
