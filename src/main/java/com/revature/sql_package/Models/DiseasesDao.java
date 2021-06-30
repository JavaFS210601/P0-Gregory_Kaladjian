package com.revature.sql_package.Models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.sql_package.Main.ConnectionUtil;

public class DiseasesDao implements DiseaseDaoInterface 
{
	//instantiate object(s)
	ConnectionUtil ConnectionUtil = new ConnectionUtil();

	@Override
	public List<Diseases> getDiseases() {
		try(Connection conn = ConnectionUtil.getConnection()){ //try to establish a DB connection, so we can run a query
			
			//initialize an empty ResultSet that will store the results of our query 
			ResultSet rs = null; //we need this for select statements, so that the returned data can get stored
					
			//write the query, assign it to a String variable
			String sql = "SELECT * FROM public.diseases;"; 
					
			//creating an object to send the query to our DB using our Connection object's createStatement() method
			Statement s = conn.createStatement(); 
					
			//execute the query (sql) using our Statement object (s), put it in our ResultSet (rs) 
			rs = s.executeQuery(sql); //again, the ResultSet just holds all the data we get back from the select statement
					
					
			List<Diseases> diseaseList = new ArrayList<>(); //create a List that will be populated with the returned Cures
					
					
			while(rs.next()) 
			{ //while there are results left in the ResultSet (rs)
				//Filling the diseases list with the diseases
				Diseases diseases = new Diseases(
				rs.getInt("cure_id"),
				rs.getString("disease_name"),
				rs.getInt("disease_urgency"));
				diseaseList.add(diseases);
			}
					
			return diseaseList; //Finally, if successful, return the list of diseases
					
			} catch (SQLException e) { //if something goes wrong accessing our data, it will get caught
				System.out.println("Something went wrong when trying to access your DB");
				e.printStackTrace();
			}
			return null; //java will yell if we don't have this, cause the try isn't guaranteed to succeed
	}
}
