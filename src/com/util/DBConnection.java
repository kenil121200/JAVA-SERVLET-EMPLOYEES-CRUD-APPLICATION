package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String Driverclass="com.mysql.cj.jdbc.Driver";
	private static final String Username="root";
	private static final String password="root";
	private static final String url="jdbc:mysql://localhost:3306/test";
	public static Connection setConnection()
	{
		Connection conn=null;
		try {
			Class.forName(Driverclass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try 
		{
			conn=DriverManager.getConnection(url, Username, password);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		if(conn==null)
		{
			System.out.println("Failed to connect with database");
		}
		return conn;
	}
	
}
