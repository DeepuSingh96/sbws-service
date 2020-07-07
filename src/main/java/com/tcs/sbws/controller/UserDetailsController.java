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

	@GetMapping("/dashboard/{username}/usersDetails")
	public List<UserDetailsEntity> getAllUserDetails(@PathVariable String username) {
		try {
			System.out.println(username);
			return userDetailsDao.getAllUsers();
		} catch (Exception e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
		}

		return null;
	}

	@GetMapping("/dashboard/{username}/usersDetails/{id}")
	public UserDetailsEntity getTodo(@PathVariable String username, @PathVariable long id) {
		return null;
	}

	@DeleteMapping("/dashboard/{username}/usersDetails/{empid}")
	public String deleteTodo(@PathVariable String username, @PathVariable String empid) {
		return userDetailsDao.deleteByOne(empid);
		
	}

	@PutMapping("/dashboard/{username}/usersDetails/{empid}")
	public UserDetailsEntity updateTodo(@PathVariable String username, @PathVariable String empid,
			@RequestBody UserDetailsEntity userDetails) {

		try {

			return userDetailsDao.update(empid, userDetails);
		}

		catch (Exception e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}

	@PostMapping("/dashboard/{username}/usersDetails/")
	public String addUserDetails(@PathVariable String username, @RequestBody UserDetailsEntity userDetails) {

		try {
			return userDetailsService.addUser(userDetails);
		} catch (Exception e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}

}
