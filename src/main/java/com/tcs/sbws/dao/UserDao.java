package com.tcs.sbws.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.tcs.sbws.entity.UserEntity;
import com.tcs.sbws.utils.EncryptionUtil;

@Component
public class UserDao {
	@Autowired
	private MongoTemplate mongoTemplate;

	public boolean addUser(UserEntity login) {
		try {
			mongoTemplate.save(login);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public UserEntity login(Query query) {
		UserEntity userEntity = null;
		try {
			userEntity = mongoTemplate.findOne(query, UserEntity.class);
			return userEntity;
		} catch (Exception e) {

		}
		return userEntity;
	}

	public String updatePwd(Query query, com.tcs.sbws.entity.UserEntity userEntityReq) {

		String updateMsg = null;
		try {

			UserEntity userEntity = getUser(query);

			if (userEntity == null) {
				updateMsg = "User Not Exist";
			} else {

				if ((EncryptionUtil.encryptText(userEntityReq.getOldPassword())).equals(userEntity.getOldPassword())) {
					// user.setAccountId(one.getAccountId());
					userEntity.setOldPassword(EncryptionUtil.encryptText(userEntityReq.getPassword()));
					userEntity.setPassword(EncryptionUtil.encryptText(userEntityReq.getPassword()));
					mongoTemplate.save(userEntity);
					updateMsg = "Password Updated";
				} else
					updateMsg = "Old password mismatch";
			}

		} catch (Exception e) {

		}

		return updateMsg;
	}

	public UserEntity getUser(Query query) {
		UserEntity userEntity = null;
		try {
			userEntity = mongoTemplate.findOne(query, UserEntity.class);
		} catch (Exception e) {
		}
		return userEntity;

	}
}
