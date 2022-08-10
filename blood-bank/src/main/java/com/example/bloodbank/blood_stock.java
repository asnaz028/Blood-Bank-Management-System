package com.example.bloodbank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class blood_stock {

	
	   @Id
	   private String bloodgrp;
	   
	   private String units;
	   
	 
	public String getBloodgrp() {
		return bloodgrp;
	}
	public void setBloodgrp(String bloodgrp) {
		this.bloodgrp = bloodgrp;
	}
	 
	public String getUnits() {
		return units;
	}
	public void setUnits(String units) {
		this.units = units;
	}
	@Override
	public String toString() {
		return "blood_stock [bloodgrp=" + bloodgrp + ", units=" + units + "]";
	}
	 
	   
	   

}
