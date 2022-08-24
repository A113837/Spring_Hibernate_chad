package com.code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestSql {

	
	public static void main(String[] args) {
		
		
		String jdbcUrl = "jdbc:mysql://192.168.3.13:1521";
		String user = "et_main_wpl";
		String pass = "etanah123";
		
		try {
			
			System.out.println("connecting to database: " + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("connection success!");
			
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("connection fail!");
			
		}

	}

}
