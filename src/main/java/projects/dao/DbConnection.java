package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

public class DbConnection {
	
	
	private static  String HOST = "localhost";
	private static  String PASSWORD= "Test123!";
	private static  int PORT = 3306;
	private static  String SCHEMA= "projects";
	private static  String USER = "root";
	
public static Connection getConnection() {
	
	String url = String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s", HOST, PORT, SCHEMA, USER, PASSWORD);

	try {
		Connection connection = DriverManager.getConnection(url);
		System.out.println("Connection is successful! " + url);
		return connection;
	} catch (SQLException e) {
		System.out.println("Connection was unsuccessful at " + url);
		throw new DbException("Connection was unsuccessful at " + url);
	}

}

}

