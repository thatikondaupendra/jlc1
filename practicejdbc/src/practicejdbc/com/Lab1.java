package practicejdbc.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jlcdb", "system", "system");
		}
		catch(Exception e) {
			System.out.println("connection problem");
		}
		String Sql="select * from mycustomers2";
		try {
			Statement st=conn.createStatement();
			ResultSet x=st.executeQuery(Sql);
			while(x.next()) {
				int sid=x.getInt(1);
				String sname=x.getString(2);
				String semail=x.getString(3);
				int ph=x.getInt(4);
				String add=x.getString(5);
				System.out.println(sid+" "+sname+" "+semail+" "+ph+" "+add);
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
