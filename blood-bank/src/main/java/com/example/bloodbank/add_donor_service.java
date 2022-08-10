package com.example.bloodbank;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
//import com.example.User_login__mvc.bloodRequest_repo;
//import com.example.User_login__mvc.blood_request;

@Service
@Transactional
public class add_donor_service {
 
	@Autowired
	private add_donor_repo repo;
	@Autowired
	private blood_stock_repo repo1;
	@Autowired
	private bloodRequest_repo repo2;
	
	@Autowired
	private UserRepo  urepo;
	
   public void add_donor(blood_donor e) {
	   repo.save(e);
   }
   
   public void manage_stock(String units,String bloodgrp) {
	  // repo1.save(e);
	   repo1.setUpdateStock(units, bloodgrp);
   }
   
    
   public List<blood_donor>getAlldonor()
   {
	   return (List<blood_donor>)repo.findAll();
   }
   
   
   public List<blood_request>getAllRequests()
   {
	   return (List<blood_request>)repo2.findAll();
   }
   
   
   public List<blood_stock>getAllstock()
   {
	   return (List<blood_stock>)repo1.findAll();
   }
   
   public blood_donor getblood_donorById(int id) {
	   Optional<blood_donor > e =repo.findById(id);
	   if(e.isPresent())
	   {
		   return e.get();
		   
	   }
	   return null;
   }
   
   public void delete_donor(int id) {
	   repo.deleteById(id);
   }
   
   public void UpdateStatus(int id) {
	   repo2.setUpdateStatus("completed", id);
   }
   
   public void delete_request(int id) {
	   repo2 .deleteById(id);
   }
   
   @Autowired
	private bloodRequest_repo repo3;
	
	public void add_request(blood_request e) {
		   repo3.save(e);
	   }
	public List<blood_request>getCompletedRequest(String status)
	{
		return repo3.getCompletedRequest(status);
	}
	
	public void add_user(User e) {
		   urepo.save(e);
	   }
}
