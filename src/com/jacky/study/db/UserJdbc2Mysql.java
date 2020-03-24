package com.jacky.study.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 使用JDBC访问数据库.
 * 
 * @author Upsky
 *
 */
public class UserJdbc2Mysql {

	public static void main(String[] args) {
		String user = "root";
		String password = "123456";
		String url = "jdbc:mysql://127.0.0.1:3306/mysql?useUnicode=true&amp;characterEncoding=UTF-8";
		String driver = "com.mysql.jdbc.Driver";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
//			con.setAutoCommit(false);
			stmt = con.createStatement();
			String sql = "SELECT * FROM proc";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(
						rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {//最后必须关闭资源
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
