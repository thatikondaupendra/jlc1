package com.packages;
//using 'execute along with preparedStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.util.JDBCUtil;

public class Lab7 {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		PreparedStatement st2=null;
		
		try {
		conn=JDBCUtil.getConnection();
		//prepare sql statement
		int cid=560;
		String cname="upendrammb";
		String email="245up@jlc.com";
		int ph=27547;
		String city="heart3";
		String SQL1="insert into mycustomers values(?,?,?,?,?)";
		String SQL2="select * from mycustomers where city=?";
		//statement creation
		st=conn.prepareStatement(SQL1);
		st2=conn.prepareStatement(SQL2);
		st.setInt(1, cid);
		st.setString(2, cname);
		st.setString(3, email);
		st.setInt(4, ph);
		st.setString(5,city);
		st2.setString(1,city);
		boolean sel=st2.execute();
		//submit sql to DB
		boolean x = st.execute();
		if (x==false) {
			System.out.println("Customer Record is Inserted Successfully");
		}
		if (sel==true) {
			System.out.println("submitted...");
			ResultSet rs=st.getResultSet();
			System.out.println("Hello Guys");
			while(rs.next()) {
				cid=rs.getInt(1);
				cname=rs.getString(2);
				email=rs.getString(3);
				ph=rs.getInt(4);
				city=rs.getString(5);
				System.out.println(cid+'\t'+cname+'\t'+email+'\t'+ph+'\t'+city);
			}

		}
		}
		catch(Exception ex) {
		System.out.println(ex);
		}
		finally {
			JDBCUtil.cleanup(st, conn);
			if(st2!=null) {
				st2.close();
			}
		}
	}
}
