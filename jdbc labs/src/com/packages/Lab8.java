package com.packages;
import java.sql.CallableStatement;
//call procedure (preparecall statement);
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.jdbc.util.JDBCUtil;

public class Lab8 {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		CallableStatement cs=null;
		
		
		try {
		conn=JDBCUtil.getConnection();
		//prepare sql statement
		String SQL="{call Arithmetic(?,?,?,?)}";
		//statement creation
		cs=conn.prepareCall(SQL);
		cs.setInt(1, 10);
		cs.setInt(2, 2);
		cs.registerOutParameter(3, Types.INTEGER);
		cs.registerOutParameter(4, Types.INTEGER);
		//submit sql to DB
		cs.execute();
		int c=cs.getInt(3);
		int d=cs.getInt(4);
		System.out.println(c);
		System.out.println(d);
		}
		catch(Exception ex) {
		System.out.println(ex);
		}
		finally {
			JDBCUtil.cleanup(cs, conn);
			}
		}
	}