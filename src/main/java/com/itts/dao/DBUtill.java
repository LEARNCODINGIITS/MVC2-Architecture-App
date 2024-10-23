package com.itts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtill {
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/db13";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static Connection con;
	
	static {
		try {
			Class.forName(DRIVER_CLASS);//Register with Driver
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);//Get the connection

		} catch (ClassNotFoundException e) {

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}

}
