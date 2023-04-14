package it.polito.tdp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	public static Connection getConnection() throws SQLException{
		String jdbcURL = "jdbc:mariadb://localhost/dizionario?user=root" ;
		Connection conn = DriverManager.getConnection(jdbcURL);			
		return conn;
	}
	
}
