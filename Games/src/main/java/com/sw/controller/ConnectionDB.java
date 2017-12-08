package com.sw.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	 Connection connection;
	public ConnectionDB(){connection=null;}
	public Connection connection1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/scope";
			String username = "root";
			String password = "";
			System.out.println("connected");
			 connection = DriverManager.getConnection(url, username, password);
				//System.out.println("OK");
				return connection;
		} catch (Exception e) {
			System.out.println("cannt connect");
		}
		return null;

	}
	public Connection Connect() {
		connection1();
		String url = "jdbc:mysql://localhost/scope";
		String username = "root";
		String password = "";
		try {
			  connection = DriverManager.getConnection(url, username, password);
			System.out.println("OK");
			return connection;
		} catch (SQLException ex) {
			// Logger.getLogger(JavaApplication21.class.getName()).log(Level.SEVERE,
			// null, ex);
		}
		return null;
	}
 }
