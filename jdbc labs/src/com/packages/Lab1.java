package com.packages;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.JDBCUtil;

public class Lab1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		try {
		conn=JDBCUtil.getConnection();
		//prepare sql statement
		String SQL="insert into mycustomers values(545,'mahaboob basha','mahaj@gmail.com',225,'heart')";
		//statement creation
		st=conn.createStatement();
		//submit sql to DB
		int x=st.executeUpdate(SQL);
		if (x==1) {
			System.out.println("Customer Record is Inserted Successfully");
		}
		else {
			System.out.println("Customer Record is not Inserted Successfully");
		}
		}
		catch(Exception ex) {
		System.out.println(ex);
		}
		finally {
			JDBCUtil.cleanup(st, conn);
		}
	}

}
