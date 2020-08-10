package com.tcs.sbws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.tcs.sbws.dao.UserDao;
import com.tcs.sbws.entity.UserDetailsEntity;
import com.tcs.sbws.entity.UserEntity;
import com.tcs.sbws.utils.EncryptionUtil;

@Service
public class UserService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDao userDao;

	public String addUser(UserEntity userEntity) {
		try {
			userEntity.setOldPassword(EncryptionUtil.encryptText(userEntity.getEmployeeNo()+"@2020"));
			boolean result = userDao.addUser(userEntity);
			if (result) {
				return "user created";
			}

		} catch (Exception e) {

		}
		return "user not created";
	}

	public UserEntity login(com.tcs.sbws.entity.UserEntity userEntityRequest) {
		UserEntity userEntityResponse = null;
		try {
			logger.info("Getting user with employeeNo: {}.", userEntityRequest.getEmployeeNo());
			String encryptedPass = EncryptionUtil.encryptText(userEntityRequest.getPassword());
			Query query = new Query();
			query.addCriteria(Criteria.where("employeeNo").is(userEntityRequest.getEmployeeNo())
					.andOperator(Criteria.where("password").is(encryptedPass)));
			userEntityResponse = userDao.login(query);
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return userEntityResponse;
	}

	public String updatePassword(UserEntity userEntityReq) {
		String msg = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("employeeNo").is(userEntityReq.getEmployeeNo()));
		    msg = userDao.updatePwd(query, userEntityReq);
       	}catch(Exception e) {
       		
       	}
		return msg;
	}

}
