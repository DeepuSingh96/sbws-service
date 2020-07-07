package com.tcs.sbws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.sbws.dao.UserDetailsDao;

@Service
public class UserDetailsService {
	
	 @Autowired
	 private UserDetailsDao userDetailsDao;
	 

	    public  String addUser(com.tcs.sbws.entity.UserDetailsEntity userDetails) {
	        try {
	            boolean result=userDetailsDao.addUser(userDetails);
	            if(result){
	                return "user created";
	            }
	        }
	        // For specifying wrong message digest algorithms
	        catch (Exception e) {
	            System.out.println("Exception thrown for incorrect algorithm: " + e);
	        }
	        return "user not created";
	    }
	
}
