package com.packages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.JDBCUtil;

public class Lab6 {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		try {
		conn=JDBCUtil.getConnection();
		//prepare sql statement
		int cid=225;
		String cname="maha";
		String email="225@gmail.com";
		int ph=2257;
		String city="heart2";
		String SQL="insert into mycustomers values(?,?,?,?,?)";
		//statement creation
		st=conn.prepareStatement(SQL);
		st.setInt(1, cid);
		st.setString(2, cname);
		st.setString(3, email);
		st.setInt(4, ph);
		st.setString(5,city);
		//submit sql to DB
		int x=st.executeUpdate();
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
