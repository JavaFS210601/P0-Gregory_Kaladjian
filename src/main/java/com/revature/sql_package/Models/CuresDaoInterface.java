package com.revature.sql_package.Models;
import java.util.List;

public interface CuresDaoInterface {

	//Reference
	//employeeId = originationId
	//rodeId = cureId
	
	public List<Cures> getCures(); //return a list of all cures
		
	public void addCure(Cures cure); //take a new Cures object and add it to the database 
		
	public void changeCureID(int originationID, int roleId); //change a Cure's cure_id based on the origination_id
		
	public void removeCures(int originationID); //delete a cure
}
