package com.packages;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jdbc.util.JDBCUtil;

public class Lab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet x=null;
		try {
		conn=JDBCUtil.getConnection();
		//prepare sql statement
		String SQL="select * from mycustomers";
		//statement creation
		ps=conn.prepareStatement(SQL);
		
		//submit sql to DB
		x=ps.executeQuery();
		System.out.println("Hello Guys");
		while(x.next()) {
			int cid=x.getInt(1);
			String cname=x.getString(2);
			String email=x.getString(3);
			int ph=x.getInt(4);
			String city=x.getString(5);
			System.out.println(cid+'\t'+cname+'\t'+email+'\t'+ph+'\t'+city);
		}
		}
		catch(Exception ex) {
		System.out.println(ex);
		}
		finally {
			JDBCUtil.cleanup(x,ps,conn);
		}
	}

}
