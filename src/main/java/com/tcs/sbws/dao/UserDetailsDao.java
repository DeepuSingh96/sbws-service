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
		query.addCriteria(Criteria.where("employee_no").is(empid));
		UserDetailsEntity existingUser = mongoTemplate.findOne(query, UserDetailsEntity.class);
		if (existingUser != null) {
			existingUser.setEmployee_name(UserDetailsEntity.getEmployee_name());
			existingUser.setAccount_name(UserDetailsEntity.getAccount_name());
			existingUser.setTeam_name(UserDetailsEntity.getTeam_name());
			existingUser.setCoid(UserDetailsEntity.getCoid());
			existingUser.setContact_no(UserDetailsEntity.getContact_no());
			existingUser.setAlternate_contact_no(UserDetailsEntity.getAlternate_contact_no());
			existingUser.setAddress(UserDetailsEntity.getAddress());
			existingUser.setPresent_location(UserDetailsEntity.getPresent_location());
			existingUser.setWork_location(UserDetailsEntity.getWork_location());
			existingUser.setParent_unit(UserDetailsEntity.getParent_unit());
			existingUser.setMode_of_working(UserDetailsEntity.getMode_of_working());
			existingUser.setAsset_id(UserDetailsEntity.getAsset_id());
			existingUser.setSbws_enabled(UserDetailsEntity.getSbws_enabled());
			existingUser.setLead_supervisor_name(UserDetailsEntity.getLead_supervisor_name());
			existingUser.setStaying_in_pg(UserDetailsEntity.getStaying_in_pg());
			existingUser.setTcs_desktop(UserDetailsEntity.getTcs_desktop());
			existingUser.setType_of_internetConnection(UserDetailsEntity.getType_of_internetConnection());
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
