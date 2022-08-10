package com.example.bloodbank;

 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
import org.springframework.context.annotation.ComponentScan;
 
 
@SpringBootApplication
 
//@ComponentScan(basePackages=("/blood-bank/src/main/java/com/example/controller/blood_bank_controller.java"))
//@ComponentScan("com.example")
public class BloodBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankApplication.class, args);
	}
    
    
	 
}
