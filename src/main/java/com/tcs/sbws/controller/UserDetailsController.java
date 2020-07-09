package com.tcs.sbws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.sbws.dao.UserDetailsDao;
import com.tcs.sbws.entity.UserDetailsEntity;
import com.tcs.sbws.service.UserDetailsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserDetailsController {

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping("/dashboard/{username}/allEmployeeDetails")
	public List<UserDetailsEntity> getAllEmployeeDetails(@PathVariable String username) {
		try {
			System.out.println(username);
			return userDetailsDao.getAllUsers();
		} catch (Exception e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
		}

		return null;
	}


	@GetMapping("/dashboard/{username}/usersDetails/{employeeNo}")
	public UserDetailsEntity getTodo(@PathVariable String username, @PathVariable long employeeNo) {
		return null;
	}

	@DeleteMapping("/dashboard/{username}/usersDetails/{employeeNo}")
	public String deleteTodo(@PathVariable String username, @PathVariable String employeeNo) {
		return userDetailsDao.deleteByOne(employeeNo);
		
	}

	@PutMapping("/dashboard/{username}/usersDetails/{employeeNo}")
	public UserDetailsEntity updateEmployeeDetails(@PathVariable String username, @PathVariable String employeeNo,
			@RequestBody UserDetailsEntity userDetails) {

		try {

			return userDetailsDao.update(employeeNo, userDetails);
		}

		catch (Exception e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}

	@PostMapping("/dashboard/{username}/usersDetails")
	public String addEmployeeDetails(@PathVariable String username, @RequestBody UserDetailsEntity userDetails) {

		try {
			return userDetailsService.addUser(userDetails);
		} catch (Exception e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}

}
