package com.tcs.sbws.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.tcs.sbws.entity.UserDetailsEntity;

@Component
public class UserDetailsDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<UserDetailsEntity> getAllUsers() {
		try {
			return mongoTemplate.findAll(UserDetailsEntity.class);
		} catch (Exception e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
			return null;
		}
	}

	public boolean addUser(com.tcs.sbws.entity.UserDetailsEntity userDetails) {
		try {
			mongoTemplate.save(userDetails);
		} catch (Exception e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
			return false;
		}
		return true;
	}

	public UserDetailsEntity update(String empid, com.tcs.sbws.entity.UserDetailsEntity UserDetailsEntity) {
		Query query = new Query();
		query.addCriteria(Criteria.where("employeeNo").is(empid));
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

	public String deleteByOne(String empid) {
		Object userEntity;
	        try {
	        	System.out.println(empid);
	        	Query query = new Query();
	        	query.addCriteria(Criteria.where("employee_no").is(empid));
	        	 userEntity = mongoTemplate.findOne(query, UserDetailsEntity.class);
	        }
			catch(Exception e)
			{
		        System.out.println("Exception thrown for incorrect algorithm: " + e);
		        return "Fails Deleted";
			}
			if(userEntity!=null) {
			try{
				mongoTemplate.remove(new Query(Criteria.where("employee_no").is(empid)), UserDetailsEntity.class);
	        }catch(Exception e)
			{
				System.out.println("Exception thrown for incorrect algorithm: " + e);
				return "Fails Deleted";
			}
			return"Success Deleted";
			
			}
			else
			{
				return "Fails Deleted";
			}
	}
}
