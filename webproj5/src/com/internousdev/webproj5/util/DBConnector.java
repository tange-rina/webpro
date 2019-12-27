package com.internousdev.webproj5.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private static String driverName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost/testdb";
	private static String user = "root";
	private static String password = "";

	public Connection getConnection(){
		Connection conn = null;

		try{
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, password);
		}//try

		catch(ClassNotFoundException e){e.printStackTrace();}
		catch(SQLException e){e.printStackTrace();}
		return conn;
	}//Connection

}//class
