package com.tcs.sbws.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import com.tcs.sbws.entity.UserDetailsEntity;

import static com.tcs.sbws.utils.Constants.*;

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
	
	public boolean addUserAdmin(com.tcs.sbws.entity.UserDetailsEntity userDetails) {
		UserDetailsEntity result;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("employeeNo").is(userDetails.getEmployeeNo()));
			result = mongoTemplate.findOne(query,UserDetailsEntity.class);
			if (result == null) {
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
			//return mongoTemplate.findAll(UserDetailsEntity.class);
			System.out.println("All status");
			//List list=new ArrayList();
			Query query = new Query();
			query.addCriteria(Criteria.where("status").ne("deleted"));
			//creating old non-generic arraylist  
			//list = );
			return mongoTemplate.find(query, UserDetailsEntity.class);
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
			return null;
		}
	}
	
	public List<UserDetailsEntity> getUserStatus(String status) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("status").is(status));
			List<UserDetailsEntity> response = mongoTemplate.find(query,UserDetailsEntity.class);
			if (response != null) {
				logger.info("User List for status of "+status);
				return response;
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
			return null;
		}
	}

	
	public List<UserDetailsEntity> getDeleteAllUsers() {
		try {
			System.out.println("deleted status");
			//List list=new ArrayList();
			Query query = new Query();
			query.addCriteria(Criteria.where("status").is("deleted"));
			//creating old non-generic arraylist  
			//list = );
			return mongoTemplate.find(query, UserDetailsEntity.class);
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
			return null;
		}
	}
	
	public List<UserDetailsEntity> getPendingAllUsers() {
		try {
			System.out.println("pending status");
			//List list=new ArrayList();
			Query query = new Query();
			query.addCriteria(Criteria.where("status").is("pending"));
			//creating old non-generic arraylist  
			//list = );
			return mongoTemplate.find(query, UserDetailsEntity.class);
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
			existingUser.setBackupResource(UserDetailsEntity.getBackupResource());
			if ((UserDetailsEntity.getTeamName().trim().length() > 0) && (UserDetailsEntity.getCoId().trim().length() > 0)
					&&(UserDetailsEntity.getPresentLocation().trim().length() > 0)
					&& (UserDetailsEntity.getWorkLocation().trim().length() > 0)
					&& (UserDetailsEntity.getAssetId().trim().length() > 0)) {
				existingUser.setStatus("completed");

			}

			else{
				existingUser.setStatus("pending");
			}
			mongoTemplate.save(existingUser);
		}

		return existingUser;
	}

	public String deleteByOne(String username,String employeeNo) {

		UserDetailsEntity userEntity;
		try {
			logger.info(employeeNo);
			Query query = new Query();
			query.addCriteria(Criteria.where("employeeNo").is(employeeNo));
			userEntity = mongoTemplate.findOne(query,UserDetailsEntity.class);
			if (userEntity != null) {
				userEntity.setStatus(STATUS_DELETED);
				userEntity.setDeleteBy(username);
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formatDateTime = now.format(formatter);
				userEntity.setDeleteOn(formatDateTime);
				mongoTemplate.save(userEntity);
			}
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
			return "Fails Deleted";
		}
		return "Success Deleted";
	}
}
