package com.tcs.sbws.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import com.tcs.sbws.entity.UserDetailsEntity;

/*
 * Created by 1430208-Yamini S
 * Dao Class for user details adding based on request of logged in user.
 */

@Component
public class UserDetailsDao {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MongoTemplate mongoTemplate;

	public boolean addUser(com.tcs.sbws.entity.UserDetailsEntity userDetails) {
		UserDetailsEntity status;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("employeeNo").is(userDetails.getEmployeeNo()));
			status = mongoTemplate.findOne(query,UserDetailsEntity.class);
			if (status == null) {
				mongoTemplate.save(userDetails);
				return true;
			}
			return false;
			
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
			return false;
		}
		
	}

	public List<UserDetailsEntity> getAllUsers() {
		try {
			return mongoTemplate.findAll(UserDetailsEntity.class);
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
			return null;
		}
	}

	public UserDetailsEntity update(String employeeNo, com.tcs.sbws.entity.UserDetailsEntity UserDetailsEntity) {
		Query query = new Query();
		query.addCriteria(Criteria.where("employeeNo").is(employeeNo));
		UserDetailsEntity existingUser = mongoTemplate.findOne(query, UserDetailsEntity.class);
		if (existingUser != null) {
			existingUser.setEmployeeName(UserDetailsEntity.getEmployeeName());
			existingUser.setAccountId(UserDetailsEntity.getAccountId());
			existingUser.setTeamName(UserDetailsEntity.getTeamName());
			existingUser.setCoId(UserDetailsEntity.getCoId());
			existingUser.setPresentLocation(UserDetailsEntity.getPresentLocation());
			existingUser.setWorkLocation(UserDetailsEntity.getWorkLocation());
			existingUser.setParentUnit(UserDetailsEntity.getParentUnit());
			existingUser.setModeOfWorking(UserDetailsEntity.getModeOfWorking());
			existingUser.setAssetId(UserDetailsEntity.getAssetId());
			existingUser.setSbwsEnabled(UserDetailsEntity.getSbwsEnabled());
			existingUser.setLeadSupervisorName(UserDetailsEntity.getLeadSupervisorName());
			existingUser.setStayingInPg(UserDetailsEntity.getStayingInPg());
			existingUser.setTcsDesktop(UserDetailsEntity.getTcsDesktop());
			existingUser.setTypeOfInternetConnection(UserDetailsEntity.getTypeOfInternetConnection());
			mongoTemplate.save(existingUser);
		}
		return existingUser;
	}

	public String deleteByOne(String employeeNo) {

		UserDetailsEntity userEntity;
		try {
			logger.info(employeeNo);
			Query query = new Query();
			query.addCriteria(Criteria.where("employeeNo").is(employeeNo));
			userEntity = mongoTemplate.findOne(query,UserDetailsEntity.class);
			if (userEntity != null) {
				mongoTemplate.remove(new Query(Criteria.where("employeeNo").is(employeeNo)),UserDetailsEntity.class);
			}
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
			return "Fails Deleted";
		}
		return "Success Deleted";
	}
}
