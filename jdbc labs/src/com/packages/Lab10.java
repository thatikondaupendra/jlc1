package com.packages;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.Types;

import com.jdbc.util.JDBCUtil;

public class Lab10 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Connection conn=null;
				Statement st=null;
				
				try {
				conn=JDBCUtil.getConnection();
				//prepare sql statement
				String SQL1="insert into mycustomers (999,'basha','baa@g',5555,'heart')";
				String SQL2="insert into mycustomers (998,'baasha','abaa@g',5455,'1heart')";
				String SQL3="update mycustomers set cname='basha' where city='heart'";
				String SQL4="update mycustomers set cname='basha' where phone=5555";
				String SQL5="delete from mycustomers where cname='baasha'";
				//statement creation
				st=conn.createStatement();
				st.addBatch(SQL1);
				st.addBatch(SQL2);
				st.addBatch(SQL3);
				st.addBatch(SQL4);
				st.addBatch(SQL5);
				int result[]=st.executeBatch();
				for(int x:result) {
					System.out.println(x);
				}
				}
				catch(Exception ex) {
				System.out.println(ex);
				}
				finally {
					JDBCUtil.cleanup(st, conn);
					}
	}
}
