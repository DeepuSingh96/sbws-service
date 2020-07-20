package com.tcs.sbws.service;

import com.tcs.sbws.dao.LoginDao;
import com.tcs.sbws.entity.UserEntity;
import com.tcs.sbws.utils.EncryptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/*
 * Created by 1430208-Yamini S
 * Service Class for Login.
 */

@Service
public class LoginService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private LoginDao loginDao;

	public String addUser(UserEntity login) {
		try {
			String encryptedPass = EncryptionUtil.encryptText(login.getPassword());
			logger.info("\n" + login.getPassword() + " : " + encryptedPass);
			login.setPassword(encryptedPass);
			boolean result = loginDao.addUser(login);
			if (result) {
				return "user created";
			}

		} catch (Exception e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
		}
		return "user not created";
	}

	public String login(com.tcs.sbws.entity.UserEntity login) {
		try {
			logger.info("Getting user with employeeNo: {}.", login.getEmployeeNo());
			String encryptedPass = EncryptionUtil.encryptText(login.getPassword());
			Query query = new Query();
			query.addCriteria(Criteria.where("employeeNo").is(login.getEmployeeNo())
					.andOperator(Criteria.where("password").is(encryptedPass)));
			boolean login1 = loginDao.login(query);
			logger.info("Getting login result.", login1);
			if (login1) {
				return "login success";
			}
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return "login fail";
	}

}
