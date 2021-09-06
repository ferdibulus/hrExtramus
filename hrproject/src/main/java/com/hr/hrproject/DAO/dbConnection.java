package com.hr.hrproject.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConnection {

	public dbConnection() {

	}

	public Connection getConn(String driver, String url, String user, String pass) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Db connection is succesfull!");
			return conn;
		} catch (Exception e) {
			System.out.println("Db connection is failed!");
			return null;
		}

	}

}
