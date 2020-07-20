package com.tcs.sbws.service;

import com.tcs.sbws.dao.AccountDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/*
 * Created by 1430208-Yamini S
 * Service Class for Account.
 */

@Service
public class AccountService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AccountDao accountDao;

	public String addAccountUser(com.tcs.sbws.entity.AccountEntity accountEntity) {
		try {
			boolean result = accountDao.addAccountUser(accountEntity);
			if (result) {
				return "user created";
			}
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return "user not created";
	}

	public boolean accountAccess(int accountId) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("accountId").is(accountId));
			boolean access = accountDao.accountAccess(query);
			if (access) {
				return true;
			}
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return false;
	}

}
