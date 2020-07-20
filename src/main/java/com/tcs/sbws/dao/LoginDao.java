package com.tcs.sbws.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.tcs.sbws.entity.UserEntity;

/*
 * Created by 1430208-Yamini S
 * Dao Class for login user request base.
 */

@Component
public class LoginDao {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public boolean addUser(com.tcs.sbws.entity.UserEntity login) {
		try {
			mongoTemplate.save(login);
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
			return false;
		}
		return true;
	}

	public boolean login(Query query) {
		try {
			UserEntity one = mongoTemplate.findOne(query, UserEntity.class);
			if (one == null) {
				return false;
			}
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
			return false;
		}
		return true;
	}

}
