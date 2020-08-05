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
	    
	    public boolean login(Query query) {
			try {
				UserEntity one = mongoTemplate.findOne(query, UserEntity.class);
				if (one == null) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
			return true;
		}
	    
	    public boolean updatePwd(com.tcs.sbws.entity.UserEntity login,String pwd) {
			try {
				login.setOldpassword(pwd);
				login.setPassword(pwd);
				mongoTemplate.save(login);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	    
		public String isUserExist(Query query,UserEntity user) {
			try {
				String encryptedoldPass = EncryptionUtil.encryptText(user.getOldpassword());
				UserEntity one = mongoTemplate.findOne(query, UserEntity.class);
				if (one == null)
				{
					return "User id not found";
				}
				else {
					
					if(encryptedoldPass.equals(one.getOldpassword()))
					{
				        user.setAccountId(one.getAccountId());
				        return "User id found";
					}
			        else
			        	return "Old password mismatch";
				}
			} catch (Exception e) {
				return "User id not found";
			}
		}

}
