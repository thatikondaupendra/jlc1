package com.packages;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.jdbc.util.JDBCUtil;

public class Lab9 {
public static void main(String[] args) {
	// TODO Auto-generated method stub
			Connection conn=null;
			CallableStatement cs=null;
			CallableStatement cs1=null;
			int mycid=0;
			int c=0;
			
			try {
			conn=JDBCUtil.getConnection();
			//prepare sql statement
			String SQL="{call findBalance(?,?)}";
			String SQL1="{call findGrade(?)}";
			//statement creation
			cs=conn.prepareCall(SQL);
			cs1=conn.prepareCall(SQL1);
			for(int i=101;i<105;i++) {
				mycid=i;
			cs1.setInt(1, mycid);
			cs.setInt(1, mycid);
			cs.registerOutParameter(2, Types.INTEGER);
			//submit sql to DB
			cs.execute();
			cs1.execute();
			c=cs.getInt(2);
			System.out.println(c);
			}
			}
			catch(Exception ex) {
			System.out.println(ex);
			}
			finally {
				JDBCUtil.cleanup(cs, conn);
				}
}
}
