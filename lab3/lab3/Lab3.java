package lab3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Lab3 {

	public static void main(String[] args) {
		try {
			/*step 1: Load the driver class*/
				Class.forName("com.mysql.cj.jdbc.Driver");
			//open connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jlcdb", "system", "system");
			//prepare sql statement
			String SQL="insert into mycustomers2 values(103,'ragu','ragu@gmail.com',1225,'aba')";
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
