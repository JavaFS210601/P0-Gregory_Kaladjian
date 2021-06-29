package com.revature.internal_package;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.sql_package.Models.Cures;
import com.revature.sql_package.Models.CuresDao;
import com.revature.sql_package.Models.Diseases;
import com.revature.sql_package.Models.DiseasesDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandLine 
{
	//Instantiating class object(s)
	Scanner keyboard = new Scanner(System.in);
	CuresDao CuresDao = new CuresDao(); //CuresDao = ed
	DiseasesDao DiseasesDao = new DiseasesDao(); //DiseasesDao = rd
	final Logger log = LogManager.getLogger(CommandLine.class);
	
	public boolean CommandLineUI(boolean connection) 
	{
		//Welcome Message for the user
		welcomeMessage();
		
		//Show UI as long as the connection is true
		while(connection == true)
		{
			connection = menuOptions(connection);
		}
		return connection;
	}
	
	
	//------------------------------------PRIVATE METHODS------------------------------------
	
	private void welcomeMessage()
	{
		System.out.println("Access Granted to the World Cure Database");
	}
	
	
	private void menuTextOptions()
	{
		System.out.println("Please choose one of the following options by typing in a number: \r\n"
				+ "1. View Cures \r\n"
				+ "2. Create Entry \r\n"
				+ "3. Update Entry \r\n"
				+ "4. Delete Entry \r\n"
				+ "5. Exit Program \r\n");
	}
	
	private boolean menuOptions(boolean connection)
	{
		menuTextOptions();
		int userInput = keyboard.nextInt();
		switch(userInput) 
		{
			case 1:
				viewCures();
				break;
				
			case 2:
				createEntry();
				break;
				
			case 3:
				updateEntry();
				break;
				
			case 4:
				deleteEntry();
				break;
				
			case 5:
				System.out.println("Program Terminated");
				connection = false;
				break;
				
			default:
				System.out.println("Program Terminated; Default Case Reached");
				connection = false;
				break;
		}
		return connection;
	}
	
	private void viewCures()
	{
		System.out.println();
		log.info("User selected all cures");
		System.out.println();
		List<Cures> cures = CuresDao.getCures();
		for (Cures c: cures)
		{
			System.out.println(c.getCure_id() + ") " + c.getCure_name() + ", Imported on:  " + c.getCreation_date());
		}
		System.out.println();
	}
	
	private void createEntry()
	{
		
		keyboard.nextLine();
		System.out.println("Enter Cure Name: ");
		String cure_name = keyboard.nextLine();
		
		System.out.println("Enter Cure ID based off disease name: 1)ABL 2)AMS 3)JBS 4)CLN 5)JLI ");
		int cureId = keyboard.nextInt();
		keyboard.nextLine();
		
		Cures Cures = new Cures(cure_name, "placeholder", cureId);

		CuresDao.addCure(Cures);
		System.out.println();
		log.info("User created entry");
		System.out.println();
	}
	
	private void updateEntry() 
	{
		System.out.println("These are the cures: ");
		List<Cures> getCures1 = CuresDao.getCures();
		
		//Print out each cure for the user to see
		for (Cures e: getCures1) {
			System.out.println(e);
		}
		
	
		System.out.println("----------------------------------------------------");
		System.out.println("Enter the Origination ID of the Cure with a changing cure_id");
		int originationID = keyboard.nextInt();
		keyboard.nextLine();
		
		System.out.println("Enter a new cure_ID");
		int cureID = keyboard.nextInt();
		keyboard.nextLine();
		
		CuresDao.changeCureID(originationID, cureID);
		System.out.println();
		log.info("User updated entry");
		System.out.println();
	}
	
	private void deleteEntry()
	{
		//First we display cures:
		System.out.println("Showing Cures, which one would you like to remove? Select by ID. ");
		List<Cures> getCures = CuresDao.getCures();
		
		//Printing out each cure
		for (Cures e: getCures)
		{
			System.out.println(e);
		}
		System.out.println("----------------------------------------------------");
		
		//retrieving input from user
		System.out.println("Enter the Origination_ID of the cure to remove: ");
		int originationIDInput = keyboard.nextInt();
		keyboard.nextLine();
		
		//remove cure
		CuresDao.removeCures(originationIDInput);
		System.out.println();
		log.info("User deleted entry");
		System.out.println();
	}
}
