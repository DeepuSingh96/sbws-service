package com.tcs.sbws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.sbws.entity.UserEntity;
import com.tcs.sbws.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class Usercontroller {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;
	

	@PostMapping("/register")
	public String registerUser(@RequestBody UserEntity userEntity) {
		logger.info("Saving user.");
		try {
			return userService.registerUser(userEntity);

		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}

	@PostMapping("/dashboard/addUser")
	public String addUser(@RequestBody UserEntity userEntity) {
		logger.info("Saving user.");
		try {
			return userService.addUser(userEntity);

		} catch (Exception e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}
	
	@PutMapping("/resetPassword")
	public String resetPassword(@RequestBody UserEntity password) {
		logger.info("Saving user.");
		try {
			return userService.updatePassword(password);
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
			return "Password Not Updated";
		}
	}
}
