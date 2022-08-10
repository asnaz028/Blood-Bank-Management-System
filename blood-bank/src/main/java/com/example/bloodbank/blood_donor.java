package com.example.bloodbank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//(name="blood_donor")

@Entity
public class blood_donor {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
   private int id;
   private String fname;
   private String lname;
   private String cno;
   private String gender;
   private String email;
   private String bloodgrp;
   private String addrs;
   
   
public blood_donor() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getCno() {
	return cno;
}
public void setCno(String cno) {
	this.cno = cno;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getBloodgrp() {
	return bloodgrp;
}
public void setBloodgrp(String bloodgrp) {
	this.bloodgrp = bloodgrp;
}
public String getAddrs() {
	return addrs;
}
public void setAddrs(String addrs) {
	this.addrs = addrs;
}
@Override
public String toString() {
	return "blood_donor [id=" + id + ", fname=" + fname + ", lname=" + lname + ", cno=" + cno + ", gender=" + gender
			+ ", email=" + email + ", bloodgrp=" + bloodgrp + ", addrs=" + addrs + "]";
}
   
   
}
