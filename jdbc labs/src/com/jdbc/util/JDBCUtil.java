package com.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtil {

	public static Connection getConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jlcdb","system","system");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	public static void cleanup(ResultSet rs,Statement st, Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(st!=null) {
				st.close();
			}
			if(conn!=null)
				conn.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void cleanup(Statement st, Connection conn) {
		try {
			if(st!=null) {
				st.close();
			}
			if(conn!=null)
				conn.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
