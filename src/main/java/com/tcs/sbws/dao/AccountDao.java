package com.tcs.sbws.dao;

import com.tcs.sbws.entity.AccountEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/*
 * Created by 1430208-Yamini S
 * Dao Class for Account Details.
 */

@Component
public class AccountDao {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MongoTemplate mongoTemplate;

	public boolean addAccountUser(com.tcs.sbws.entity.AccountEntity accountEntity) {
		try {
			mongoTemplate.save(accountEntity);
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
			return false;
		}
		return true;
	}

	public boolean accountAccess(Query query) {
		try {
			AccountEntity one = mongoTemplate.findOne(query, AccountEntity.class);
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
