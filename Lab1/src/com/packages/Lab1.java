package com.packages;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		/*step 1: Load the driver class*/
		Class.forName("com.mysql.cj.jdbc.Driver");
		//open connection
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jlcdb", "system", "system");
		//prepare sql statement
		String SQL="insert into mycustomers values(545,'mahaboob basha','mahaj@gmail.com',225,'heart')";
		//statement creation
		Statement st=conn.createStatement();
		//submit sql to DB
		int x=st.executeUpdate(SQL);
		if (x==1) {
			System.out.println("Customer Record is Inserted Successfully");
		}
		else {
			System.out.println("Customer Record is not Inserted Successfully");
		}
		st.close();
		conn.close();
		}
		catch(Exception ex) {
		System.out.println(ex);
		}
	}

}
