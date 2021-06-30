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

public class CuresDao implements CuresDaoInterface {
	//instantiate object(s)
	ConnectionUtil ConnectionUtil = new ConnectionUtil();
	
	@Override
	public List<Cures> getCures() {
		try(Connection conn = ConnectionUtil.getConnection()){ //try to establish a DB connection, so we can run a query
					
			//initialize an empty ResultSet that will store the results of our query 
			ResultSet rs = null; //we need this for select statements, so that the returned data can get stored
					
			//write the query, assign it to a String variable
			String sql = "SELECT * FROM public.cures;"; 
					
			//creating an object to send the query to our DB using our Connection object's createStatement() method
			Statement s = conn.createStatement(); 
					
			//execute the query (sql) using our Statement object (s), put it in our ResultSet (rs) 
			rs = s.executeQuery(sql); //again, the ResultSet just holds all the data we get back from the select statement
					
					
			List<Cures> CuresList = new ArrayList<>(); //create a List that will be populated with the returned Cures
					
					
			while(rs.next()) 
			{ //while there are results left in the ResultSet (rs)
						
	
				Cures Cures = new Cures(
				rs.getInt("origination_id"),
				rs.getString("cure_name"),
				rs.getString("creation_date"),
				rs.getInt("cure_id")
				);

				CuresList.add(Cures);
		
			}
					
			return CuresList; 
					
			} catch (SQLException e) { //if something goes wrong accessing our data, it will get caught
				System.out.println("Something went wrong when trying to access your DB");
				e.printStackTrace();
			}
			return null; //java will yell if we don't have this, cause the try isn't guaranteed to succeed
	}

	@Override
	public void addCure(Cures cure) 
	{
		try(Connection conn = ConnectionUtil.getConnection()) {
				
				//This is the way I want to get the current date in the appropriate format
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //date formatter formats dates 
				
				Date date = new Date(); //new date from java.util package
				
				String currentDate = dateFormat.format(date); //make a String that represents today's date in the format we want (line 69)
				
				//we're going to create a SQL statement using parameters
				String sql = "INSERT INTO cures (cure_name, creation_date, cure_id) " //creating a line break for readability
						+ "VALUES (?, ?, ?);"; //these are parameters!!! We have to now specify the value of each "?"
				
				
				PreparedStatement ps = conn.prepareStatement(sql); //we use PreparedStatements for SQL commands with parameters
				
				//use the PreparedStatement object's methods to insert values into the SQL query's ?s
				//this requires two arguments, the number of the "?", and the value to give it
				ps.setString(1, cure.getCure_name());
				ps.setDate(2, java.sql.Date.valueOf(currentDate)); //this takes our Java Date, and turns it into a SQL Date.
				ps.setInt(3, cure.getCure_id());
				
				//this method actually sends and executes the SQL command that we built
				ps.executeUpdate(); //we use executeUpdate for inserts, updates, and deletes. 
				
				//send confirmation to the console if successful
				System.out.println("Cure Name: " + cure.getCure_name() + " created sucessfully");
				
			} catch(SQLException e) {
				System.out.println("Add Cure failed!");
				e.printStackTrace();
			}
			
	}
		

	@Override
	public void changeCureID(int originationID, int roleId) 
	{
		try(Connection conn = ConnectionUtil.getConnection()) 
		{
			//notice how there are no ResultSet object in methods that don't include select statements...
			//because we aren't returning anything! Only changing stuff in the DB, not getting data from it.
			String sql = "UPDATE cures SET cure_id = ? WHERE origination_id = ?;";
					
			PreparedStatement ps = conn.prepareStatement(sql); //make a PreparedStatement using the SQL String we made 
					
			//adding values to the wildcard parameters based on the user's input
			ps.setInt(1, roleId);
			ps.setInt(2, originationID);
					
			ps.executeUpdate(); //Run the PreparedStatement now that we've given values to its parameters
					
			System.out.println("Cure role_id changed to: " + roleId);
					
		} catch (SQLException e) {
			System.out.println("Change Cure failed!");
			e.printStackTrace();
		}
	}

	@Override
	public void removeCures(int originationID) 
	{
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM cures WHERE origination_id = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, originationID);
			ps.executeUpdate();
			System.out.println("Removed Cure: " + originationID);
		}
		catch(SQLException e) {
			System.out.println("Delete Cure failed!");
			e.printStackTrace();
		}
	}

}
