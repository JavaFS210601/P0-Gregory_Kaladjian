package com.revature.internal_package;
import com.revature.sql_package.Main.ConnectionUtil;


public class Launcher {
	public static void main(String[] args) 
	{
		//initializing variable(s)
		boolean connection = false;
		
		//instantiating classes
		ConnectionUtil ConnectionUtil = new ConnectionUtil();
		CommandLine CommandLine = new CommandLine();
		
		//checking connection
		connection = ConnectionUtil.checkConnection();
		
		//runs the method until the connection is false
		while (connection == true) 
		{
			connection = CommandLine.CommandLineUI(connection);	
		}
	}
}
