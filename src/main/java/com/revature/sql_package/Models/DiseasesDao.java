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

	@Override
	public List<Diseases> getDiseasesByTitle(String diseaseName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDiseaseUrgency(int newUrgency, String diseaseName) {
		// TODO Auto-generated method stub
		
	}
	//public void updateDiseaseUrgency(int newUrgency, String diseaseName)
	
}
