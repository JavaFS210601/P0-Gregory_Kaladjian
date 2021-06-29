package com.revature.sql_package.Main;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
//This class contains the logic that manages the connection to our database
//It will have a method called getConnection() that will return connections objects
//We will need these Connections objects in our DAO layer to interact with our database

public class ConnectionUtil
{
	public Connection getConnection() throws SQLException
	{
	//For compatibility with other technologies/frameworks, we'll need to register the driver
	//This process makes the application aware of what Driver class (what SQL dialect) we're using
	
	try {
		Class.forName("org.postgresql.Driver");
	} catch (ClassNotFoundException e) 
	{
		System.out.println("Class wasn't found");
		e.printStackTrace(); //prints the exception message to the console
	}
	//Hard coding url, username, and password to send to our SQL Database in order to use it properly.
	String url = "jdbc:postgresql://javafs210601.cvbm9aejcfkb.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=public";
	String username = "";
	String password = "";
	
	//removed username and password
	
	return DriverManager.getConnection(url, username, password);
	}
	
	
	public boolean checkConnection()
	{	
		//initializing variable(s)
		boolean connection = false;
		
		//Checking SQL Connection
		try (Connection conn = getConnection()){
			System.out.println("Connection Successful");
			connection = true;
		} catch (SQLException e) {
			System.out.println("Connection Not Successful");
			e.printStackTrace();
			connection = false;
		}
		return connection;
	}
}
