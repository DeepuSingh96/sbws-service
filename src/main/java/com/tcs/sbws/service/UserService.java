package com.tcs.sbws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.tcs.sbws.dao.UserDao;
import com.tcs.sbws.entity.UserEntity;
import com.tcs.sbws.utils.EncryptionUtil;

@Service
public class UserService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDao userDao;

	public String addUser(UserEntity userEntity) {
		try {

			boolean result = userDao.addUser(userEntity);
			if (result) {
				return "user created";
			}

		} catch (Exception e) {

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
			boolean login1 = userDao.login(query);
			logger.info("Getting login result.", login1);
			if (login1) {
				return "login success";
			}
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return "login success";
	}

	public String registerUser(UserEntity userEntity) {
		// TODO Auto-generated method stub
		return null;
	}

}
