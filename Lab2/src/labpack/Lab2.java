package labpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab2{

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ResultSet x=null;
		Connection conn=null;
		PreparedStatement ps=null;
		boolean j;
		
		try {
		/*step 1: Load the driver class*/
		Class.forName("com.mysql.cj.jdbc.Driver");
		//open connection
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jlcdb", "system", "system");
		//prepare sql statement
		String SQL="select * from mycustomers where city=?";
		//statement creation
		ps=conn.prepareStatement(SQL);
		ps.setString(1, "heart");
		//submit sql to DB
		j=ps.execute();
		if(j==true) {
	x=ps.getResultSet();
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
		}
		catch(Exception ex) {
		System.out.println(ex);
		}
		finally {
			try {
			if(x!=null)
			x.close();
			if(ps!=null)
			ps.close();
			if(conn!=null)
			conn.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			}
		}
	}