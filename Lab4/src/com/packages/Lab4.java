package com.packages;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Lab4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		/*step 1: Load the driver class*/
		Class.forName("com.mysql.cj.jdbc.Driver");
		//open connection
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jlcdb", "system", "system");
		//prepare sql statement
		String SQL="select * from mycustomers2";
		//statement creation
		Statement st=conn.createStatement();
		//submit sql to DB
		ResultSet x=st.executeQuery(SQL);
		System.out.println("Hello Guys");
		while(x.next()) {
			int cid=x.getInt(1);
			String cname=x.getString(2);
			String email=x.getString(3);
			int ph=x.getInt(4);
			String city=x.getString(5);
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
