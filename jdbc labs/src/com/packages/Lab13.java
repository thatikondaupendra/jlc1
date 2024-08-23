package com.packages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.util.JDBCUtil;

public class Lab13 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		/*step 1: Load the driver class*/
		Class.forName("com.mysql.cj.jdbc.Driver");
		//open connection
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jlcdb", "system", "system");
		//prepare sql statement
		String SQL="select * from mycustomers";
		//statement creation
		Statement st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//submit sql to DB
		ResultSet x=st.executeQuery(SQL);
		System.out.println("Hello Guys");
		System.out.println(st.getResultSetType());
		System.out.println(st.getResultSetConcurrency());
		System.out.println(st.getResultSetHoldability());
		while(x.next()) {
			int cid=x.getInt(1);
			String cname=x.getString(2);
			String email=x.getString(3);
			int ph=x.getInt(4);
			String city=x.getString(5);
			System.out.println(cid+'\t'+cname+'\t'+email+'\t'+ph+'\t'+city);
		}
		while(x.previous()) {
			int cid=x.getInt(1);
			String cname=x.getString(2);
			String email=x.getString(3);
			int ph=x.getInt(4);
			String city=x.getString(5);
			System.out.println(cid+'\t'+cname+'\t'+email+'\t'+ph+'\t'+city);
		}
		System.out.println(x.isFirst());
		System.out.println(x.isBeforeFirst());
		x.first();
		System.out.println(x.isFirst());
		
		System.out.println("1 record");
		int cid=x.getInt(1);
		String cname=x.getString(2);
		String email=x.getString(3);
		int ph=x.getInt(4);
		String city=x.getString(5);
		System.out.println(cid+'\t'+cname+'\t'+email+'\t'+ph+'\t'+city);
		System.out.println(x.isLast());
		
		x.last();
		System.out.println("2 record");
		cid=x.getInt(1);
		cname=x.getString(2);
		email=x.getString(3);
		ph=x.getInt(4);
		city=x.getString(5);
		System.out.println(cid+'\t'+cname+'\t'+email+'\t'+ph+'\t'+city);
		
		//insert record into result set
		x.moveToInsertRow();
		x.updateInt(1, 2245);
		x.updateString(2, "usha");
		x.updateString(3, "usha@gm");
		x.updateInt(4, 2250);
		x.updateString(5, city);
		x.insertRow();
		
		while(x.next()) {
			cid=x.getInt(1);
			cname=x.getString(2);
			email=x.getString(3);
			ph=x.getInt(4);
			city=x.getString(5);
			System.out.println(cid+'\t'+cname+'\t'+email+'\t'+ph+'\t'+city);
		}
		
		st.close();
		conn.close();
		}
		catch(Exception ex) {
		System.out.println(ex);
		}
	}
}
