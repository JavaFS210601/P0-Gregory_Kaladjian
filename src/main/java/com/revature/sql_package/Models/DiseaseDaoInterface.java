package com.revature.sql_package.Models;
import java.util.List;

public interface DiseaseDaoInterface 
{
	//Role = Diseases
	public List<Diseases> getDiseasesByTitle(String diseaseName);
	
	public void updateDiseaseUrgency(int newUrgency, String diseaseName);
}
