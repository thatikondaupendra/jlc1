package com.packages;
//In this lab we see how the 'statement' works and along with the external data passed as parameters to the sql string;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.JDBCUtil;

public class Lab5 {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		try {
		conn=JDBCUtil.getConnection();
		//prepare sql statement
		int cid=5457;
		String cname="upendra";
		String email="Uppi@gmail.com";
		int ph=4557;
		String city="heart1";
		String SQL=String.format("insert into mycustomers values(%d,'%s','%s',%d,'%s')", cid,cname,email,ph,city);
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
