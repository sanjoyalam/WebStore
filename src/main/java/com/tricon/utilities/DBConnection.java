package com.tricon.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
Connection conn;
	
	
	public DBConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection("jdbc:mysql://localhost/HR?" + "user=root&password=root");
		
	}
	
	public Connection getInstance(){
		return conn;
	}

}
