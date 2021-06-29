package com.revature.sql_package.Models;

public class Cures {
	//initializing variables
	private int origination_id;
	private String cure_name;
	private String Creation_date;
	private int cure_id;
	
	//using alt+shift+s to generate methods
	
	//no args constructor
	public Cures() {
		super();
	}

	//all args constructor
	public Cures(int origination_id, String cure_name, String Creation_date, int cure_id) {
		super();
		this.origination_id = origination_id;
		this.cure_name = cure_name;
		this.Creation_date = Creation_date;
		this.cure_id = cure_id;
	}
	
	//all args constructor minus origination_id constructor so we can insert new cures
	public Cures(String cure_name, String Creation_date, int cure_id) {
		super();
		this.cure_name = cure_name;
		this.Creation_date = Creation_date;
		this.cure_id = cure_id;
	}

	
	//Using toString so we can see the text not the memory address of each string
	@Override
	public String toString() {
		return "Cures [origination_id=" + origination_id + ", cure_name=" + cure_name + ", Creation_date="
				+ Creation_date + ", cure_id=" + cure_id + "]";
	}

	//assigns each object a hashcode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cure_id;
		result = prime * result + ((cure_name == null) ? 0 : cure_name.hashCode());
		result = prime * result + ((Creation_date == null) ? 0 : Creation_date.hashCode());
		result = prime * result + origination_id;
		return result;
	}

	//lets us compare objects by hash code
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cures other = (Cures) obj;
		if (cure_id != other.cure_id)
			return false;
		if (cure_name == null) {
			if (other.cure_name != null)
				return false;
		} else if (!cure_name.equals(other.cure_name))
			return false;
		if (Creation_date == null) {
			if (other.Creation_date != null)
				return false;
		} else if (!Creation_date.equals(other.Creation_date))
			return false;
		if (origination_id != other.origination_id)
			return false;
		return true;
	}

	//need these to access our fields since we made them private
	public int getOrigination_id() {
		return origination_id;
	}

	public String getCure_name() {
		return cure_name;
	}

	public void setCure_name(String cure_name) {
		this.cure_name = cure_name;
	}

	public String getCreation_date() {
		return Creation_date;
	}

	public void setCreation_date(String Creation_date) {
		this.Creation_date = Creation_date;
	}

	public int getCure_id() {
		return cure_id;
	}

	public void setCure_id(int cure_id) {
		this.cure_id = cure_id;
	}
	
	
}
