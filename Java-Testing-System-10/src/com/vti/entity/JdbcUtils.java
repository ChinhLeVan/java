package com.vti.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	public void isConnectedForTesting() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/testing_system?autoReconnect=true&useSSL=false&characterEncoding=latin1";
		String username ="root";
		String password = "Root";

		// register the driver class with DriverManager
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Step 2: get a Database Connection
		Connection connection = (Connection) DriverManager.getConnection(url,username,password);
		System.out.println("Connect success!");
	}
}
