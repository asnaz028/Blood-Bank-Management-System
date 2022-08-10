package com.example.bloodbank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class admin {

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	   private int id;
	   private String username;
	   private String passsword;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasssword() {
		return passsword;
	}
	public void setPasssword(String passsword) {
		this.passsword = passsword;
	}
	@Override
	public String toString() {
		return "admin [id=" + id + ", username=" + username + ", passsword=" + passsword + "]";
	}
	   
	   
}
