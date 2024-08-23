package com.packages;
//batches
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.util.JDBCUtil;

public class Lab12 {
	public static void main(String[] args) { 
		Connection con=null; 
		PreparedStatement ps=null; 
		Object [][] mycustomers= { 
		{560,"udayki","uday",400,"Hyd"}, 
		{561,"hello","bharath",500,"gm"}, 
		{562,"Bharath","bha@gmail",518,"litheart"}, 
		}; 
		try { 
		con=JDBCUtil.getConnection(); 
		String SQL="insert into mycustomers values(?,?,?,?,?)"; 
		ps=con.prepareStatement(SQL);
		for( Object [] mycust : mycustomers) {
			int para=1;
		for(Object one:mycust) {
			ps.setObject(para++, one);
		}
		ps.addBatch(); 
		} 
		int results[]= ps.executeBatch(); 
		for(int x : results) { 
		System.out.println(x); 
		} 
		System.out.println("Done !!! "); 
		}
				catch(Exception ex) {
				System.out.println(ex);
				}
				finally {
					JDBCUtil.cleanup(ps, con);
					}
	}
}
