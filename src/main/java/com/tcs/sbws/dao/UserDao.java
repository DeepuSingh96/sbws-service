package com.tcs.sbws.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.tcs.sbws.entity.addUserEntity;

@Component
public class UserDao {
	 @Autowired
	    private MongoTemplate mongoTemplate;

	    public boolean addUser(addUserEntity login) {
	        try {
	            mongoTemplate.save(login);
	        } catch (Exception e) {
	            System.out.println("Exception thrown for incorrect algorithm: " + e);
	            return false;
	        }
	        return true;
	    }

}
