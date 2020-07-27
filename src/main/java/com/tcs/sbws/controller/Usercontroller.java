package com.tcs.sbws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.sbws.entity.addUserEntity;
import com.tcs.sbws.service.addUserservice;



@CrossOrigin(origins="*")
@RestController
public class Usercontroller {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	 @Autowired
	    private addUserservice addUserService;
	 
	 @RequestMapping("/hello")
	 public String Hello() {
		 return "Hi this is spring boot apllication";
	 }
	 
		@PostMapping( "/dashboard/addUser")
	    public String addUser1(@RequestBody addUserEntity login1) {
			 LOG.info("Saving user.");
	        try
	        {
	        	addUserEntity login=login1;
	        	System.out.print(login);
	            return addUserService.addUser(login1);

	        }
	        catch (Exception e) {
	            System.out.println("Exception thrown for incorrect algorithm: " + e);
	        }
	        return null;
	    }
}
