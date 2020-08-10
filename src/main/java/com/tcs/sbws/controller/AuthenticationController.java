package com.tcs.sbws.controller;

import com.tcs.sbws.entity.UserEntity;
import com.tcs.sbws.service.UserService;
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
public class AuthenticationController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public UserEntity userLogin(@RequestBody UserEntity login) {
		logger.info("Login user");
		UserEntity userEntityResponse = null;
		try {
			userEntityResponse = userService.login(login);
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return userEntityResponse;
	}
}
