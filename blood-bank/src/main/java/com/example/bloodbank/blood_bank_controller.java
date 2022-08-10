package com.example.bloodbank;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

 
 

 
@RestController 
class blood_bank_controller {

	@Autowired
	private add_donor_service service;

	@GetMapping("/admin")
	public ModelAndView index() {
		
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("index");
		 

		 return modelAndView;
		//return "index";
	}

	@GetMapping("/add_donor")
	public  ModelAndView add_donor() {

		
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("add_donor");
		  
		  return modelAndView;
		 
		//return "add_donor";

	}

	@GetMapping("/stock_management")
	public ModelAndView stockmanagement(Model n) {

		
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("stock_management");
		  
		 // return modelAndView;
		 
		List<blood_stock> list = service.getAllstock();
		n.addAttribute("list", list);

		return modelAndView;
		
	//	return "stock_management";

	}

	@GetMapping("/admin_dashboard")
	public ModelAndView admin_dashboard() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin_dashboard");

		return modelAndView;

	}

	 
	@GetMapping("/edit")
	public ModelAndView edit() {
		
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("edit");
		  
		  return modelAndView;
		 
		//return "edit";
	}

	@GetMapping("/donor_details")
	public ModelAndView donor_details(Model n) {

		List<blood_donor> list = service.getAlldonor();
		n.addAttribute("list", list);

		
		  ModelAndView modelAndView=new ModelAndView();
		  modelAndView.setViewName("donor_details");
		 

		 return modelAndView;
		//return "donor_details";
	}
	
	@GetMapping("/bloodRequests")
	public ModelAndView bood_requests(Model n) {

		/*List<blood_request> list = service.getAllRequests();
		n.addAttribute("list", list);*/

		List<blood_request> list = service.getCompletedRequest("pending");
		n.addAttribute("list", list);
		
		
		  ModelAndView modelAndView=new ModelAndView();
		  modelAndView.setViewName("bloodRequests");
		 

		 return modelAndView;
	//	return "bloodRequests";
	}

	@PostMapping("/add_doner")
	public ModelAndView add_donor(@ModelAttribute blood_donor e, HttpSession session) {

		System.out.println(e);

		service.add_donor(e);
		session.setAttribute("msg", "blood Doner Details Added Succesfully...");
		//return "redirect:/";
		
		ModelAndView modelAndView=new ModelAndView();
		  modelAndView.setViewName("redirect:/donor_details");
		 

		 return modelAndView;
		
		//return "add_donor";
	}

	@RequestMapping("/manage_stock")
	public ModelAndView manage_stock(@RequestParam("units")String units,@RequestParam ("bloodgrp")String bloodgrp,HttpSession session) {

		//System.out.println(e);

		service.manage_stock(units,bloodgrp);
		session.setAttribute("msg", "blood Stock Updated Succesfully...");
		
		ModelAndView modelAndView=new ModelAndView();
		  modelAndView.setViewName("redirect:/stock_management");
		
		  return modelAndView;
		  
		//return "stock_management";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable(name="id") int id, Model m) {
		blood_donor blood = service.getblood_donorById(id);
		m.addAttribute("blood", blood);

		
		  ModelAndView modelAndView=new ModelAndView();
		  modelAndView.setViewName("edit");
		 

		 return modelAndView;
		//return "edit";
	}

	@PostMapping("/update")
	public ModelAndView update_donor(@ModelAttribute blood_donor e, HttpSession session) {

		System.out.println(e);

		service.add_donor(e);
		session.setAttribute("msg", "blood Doner Details Updated Succesfully...");
		
		 ModelAndView modelAndView=new ModelAndView();
		  modelAndView.setViewName("redirect:/donor_details");
		 

		 return modelAndView;
		//return "donor_details";
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete_donor(@PathVariable (value = "id") int id, HttpSession session) {

		service.delete_donor(id);
		session.setAttribute("msg", "blood Doner Details Deleted Succesfully...");
		
		 ModelAndView modelAndView=new ModelAndView();
		  modelAndView.setViewName("redirect:/donor_details");
		 

		 return modelAndView;
		
		//return "donor_details";

	}
	
	/*@Autowired
	private UserRepo urepo;
	@RequestMapping("/register-user/{fname}/{lname}/{email}/{username}/{password}")
	public String registUser(@PathVariable("fname") String fname,
			@PathVariable("lname") String lname,
	@PathVariable("email") String email,@PathVariable("username") String username,@PathVariable("password") String password)
           {
		User u= new User();
		u.setFname(fname);
		u.setLname(lname);
		u.setEmail(email);
		u.setUsername(username);
		u.setPasssword(password);
		urepo.save(u);
		return "Succesfully registerd !";
	}*/
	
	@PostMapping("/UpdateStatus/{id}")
	public ModelAndView UpdateStatus(@PathVariable (name="id")int id,HttpSession session) {
		service.UpdateStatus(id);
		//System.out.println(e);

		//service.add_request(e);
		session.setAttribute("msg", "Blood Request completed Succesfully...");
		
		 ModelAndView modelAndView=new ModelAndView();
		  modelAndView.setViewName("redirect:/bloodRequests");
		 

		 return modelAndView;
		
	//	return "bloodRequests";
		 
	}
	
	@GetMapping("/deleteReq/{id}")
	public ModelAndView delete_request(@PathVariable(name="id")int id, HttpSession session) {

		service.delete_request(id);
		session.setAttribute("msg", "blood Request Deleted Succesfully...");
		
		 ModelAndView modelAndView=new ModelAndView();
		  modelAndView.setViewName("redirect:/bloodRequests");
		 

		 return modelAndView;
		
	//	return "redirect:/";

	}
	
	@GetMapping("/completedRequest")
	public ModelAndView completed_requests(Model n) {

		List<blood_request> list = service.getCompletedRequest("completed");
		n.addAttribute("list", list);

		
		  ModelAndView modelAndView=new ModelAndView();
		  modelAndView.setViewName("completedRequest");
		 

		 return modelAndView;
		//return "completedRequest";
	}
	
	
	@Autowired
	private admin_repo  adrepo;
	
	@RequestMapping("/adminLogin")
	public ModelAndView loginHomePage(@RequestParam("username") String username,
			@RequestParam("password") String password,Model model,HttpSession session){
		
		ModelAndView modelAndView1 = new ModelAndView();
		  modelAndView1.setViewName("redirect:/admin_dashboard");
		  
		  ModelAndView modelAndView2 = new ModelAndView();
		  modelAndView2.setViewName("redirect:/index");
		
		
		admin u=null;
		try {
		   u=adrepo.findByusername(username);	
		   if(u!=null) {
				model.addAttribute("username",username);
				 return modelAndView1;
				
			//	return "admin_dashboard";
			}
		   else {
				session.setAttribute("msg","User not found,please check again..");
			   return modelAndView2;
				//return "index";
		   }
		}catch(Exception e) {
			System.out.println("User not found");
			 return modelAndView2;
			//return "index";
		}
		/*if(u!=null) {
			model.addAttribute("username",username);
			return "admin_dashboard";
		}
		model.addAttribute("error,User not found,please check again..");
		return "index";*/
	}
	
	@Autowired
	private UserRepo  urepo;
	
	
	@RequestMapping("/")
	public ModelAndView login() {

		
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("/login");
		  
		  return modelAndView;
		 
		//return "login";

	}
	
	@GetMapping("/homePage")
	public ModelAndView homePage() {

		
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("homePage");
		  
		  return modelAndView;
		 
	//	return "homePage";

	}
	
	@RequestMapping("/log_in")
	public ModelAndView userloginHomePage(@RequestParam("username") String username,@RequestParam("password") String password,Model model,HttpSession session){
		
		 ModelAndView modelAndView1 = new ModelAndView();
		  modelAndView1.setViewName("/");
		  
		  ModelAndView modelAndView2 = new ModelAndView();
		  modelAndView2.setViewName("homePage");
		
		User u=null;
		try {
		   u=urepo.findByusername(username);	
		}catch(Exception e) {
			System.out.println("User not found");
			return modelAndView1;
			//return "login";
		}
		if(u!=null) {
			model.addAttribute("username",username);
			return modelAndView2;
			//return "homePage";
		}
		session.setAttribute("msg","User not found,please check again..");
		return modelAndView1;
	//	return "login";
	}
	
	@RequestMapping("/register")
	public ModelAndView goToRegistrationPage() {
		
		ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("register");
		  
		  return modelAndView;
		//return "register";
	} 
	
	
	/*  @RequestMapping("/set-user") 
	  public  ModelAndView goToRegisterMicroservice(@RequestParam("fname") String fname,@RequestParam("lname") String lname, @RequestParam("email") String email,@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session){ 
		  //code to got to registr microservice
	  restTemplate.getForObject("http://localhost:8080/register-user/{"+fname+"}/{"+lname+"}/{"+email+"}/{"+username+"}/{"+password+"}",String.class);
	  
	  session.setAttribute("msg","succesfully registerd,kindly login to continue");
	 
	 ModelAndView modelAndView1 = new ModelAndView();
	  modelAndView1.setViewName("login");
	  
	  return modelAndView1;
	  
	  //return "login";
	  }*/
	 
	
	@PostMapping("/set-user")
	public ModelAndView add_user(@ModelAttribute User e, HttpSession session) {

		System.out.println(e);

		service.add_user(e);
		session.setAttribute("msg", " Succesfully Registerd...");
		
		ModelAndView modelAndView1 = new ModelAndView();
		  modelAndView1.setViewName("redirect:/");
		  
		  return modelAndView1;
		//return "login";
	}
	
	 
	
	@PostMapping("/add_request")
	public ModelAndView add_request(@ModelAttribute blood_request e, HttpSession session) {

		System.out.println(e);

		service.add_request(e);
		session.setAttribute("msg", "Blood Request Added Succesfully...");
		
		 ModelAndView modelAndView2 = new ModelAndView();
		  modelAndView2.setViewName("redirect:/homePage");
		  
		  return modelAndView2;
		  
		  
		//return "homePage";
	}
}
