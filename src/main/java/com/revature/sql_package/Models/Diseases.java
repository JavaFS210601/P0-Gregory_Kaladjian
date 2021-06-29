package com.revature.sql_package.Models;

public class Diseases {

	private int cure_id;
	private String disease_name;
	private int disease_urgency;
	
	
	//alt+shift+s to create these boilerplate methods
	
	public Diseases() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Diseases(int cure_id, String disease_name, int disease_urgency) {
		super();
		this.cure_id = cure_id;
		this.disease_name = disease_name;
		this.disease_urgency = disease_urgency;
	}
	
	public Diseases(String disease_name, int disease_urgency) {
		super();
		this.disease_name = disease_name;
		this.disease_urgency = disease_urgency;
	}


	@Override
	public String toString() {
		return "Diseases [cure_id=" + cure_id + ", disease_name=" + disease_name + ", disease_urgency="
				+ disease_urgency + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cure_id;
		result = prime * result + ((disease_name == null) ? 0 : disease_name.hashCode());
		result = prime * result + disease_urgency;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diseases other = (Diseases) obj;
		if (cure_id != other.cure_id)
			return false;
		if (disease_name == null) {
			if (other.disease_name != null)
				return false;
		} else if (!disease_name.equals(other.disease_name))
			return false;
		if (disease_urgency != other.disease_urgency)
			return false;
		return true;
	}


	public int getCure_id() {
		return cure_id;
	}


	public void setCure_id(int cure_id) {
		this.cure_id = cure_id;
	}


	public String getDisease_name() {
		return disease_name;
	}


	public void setDisease_name(String disease_name) {
		this.disease_name = disease_name;
	}


	public int getDisease_urgency() {
		return disease_urgency;
	}


	public void setDisease_urgency(int disease_urgency) {
		this.disease_urgency = disease_urgency;
	}
	
	
	
}
