package com.packages;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.jdbc.util.JDBCUtil;

public class Lab11 {
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
		ps.setInt(1, (int)mycust[0]); 
		ps.setString(2, (String) mycust[1]); 
		ps.setString(3, (String) mycust[2]); 
		ps.setInt(4, (int) mycust[3]); 
		ps.setString(5, (String) mycust[4]); 
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
