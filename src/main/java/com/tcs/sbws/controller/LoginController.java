package com.tcs.sbws.controller;

import com.tcs.sbws.entity.UserEntity;
import com.tcs.sbws.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
* Created by 1430208-Yamini S
* Controller Class for login api which performs operations adding and login user.
*/

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private LoginService loginService;

	@PostMapping("/addUser")
	public String addUser(@RequestBody UserEntity login1) {
		logger.info("Saving user.");
		try {
			return loginService.addUser(login1);

		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}

	@PostMapping("/login")
	public String userLogin(@RequestBody UserEntity login) {
		logger.info("Saving user.");
		try {
			return loginService.login(login);
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}
}
