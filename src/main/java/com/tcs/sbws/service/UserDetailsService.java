package com.tcs.sbws.service;

import com.tcs.sbws.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import com.tcs.sbws.dao.UserDetailsDao;
import com.tcs.sbws.entity.UserDetailsEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.tcs.sbws.utils.Constants.STATUS_PENDING;

/*
 * Created by 1430208-Yamini S
 * Service Class for UserDetails.
 */
@Service
public class UserDetailsService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDetailsDao userDetailsDao;

	public String addUser(com.tcs.sbws.entity.UserDetailsEntity userDetails) {
		try {
			boolean result = userDetailsDao.addUser(userDetails);
			if (result) {
				return "User request created";
			}
			else
			{
				return "User request alredy present";
			}
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return "user not created";
	}
	public String addUserAdmin(String username,com.tcs.sbws.entity.UserDetailsEntity userDetails) {
		UserDetailsEntity request =new UserDetailsEntity();
		request.setEmployeeNo(userDetails.getEmployeeNo());
		request.setEmployeeName(userDetails.getEmployeeName());
		request.setAccountId(userDetails.getAccountId());
	/*	request.setTeamName(Constants.DEFAULT);
		request.setCoId(Constants.DEFAULT);
		request.setPresentLocation(Constants.DEFAULT);
		request.setWorkLocation(Constants.DEFAULT);
		request.setAssetId(Constants.DEFAULT);
		//fields end
		request.setParentUnit(Constants.DEFAULT);
		request.setModeOfWorking(Constants.DEFAULT);
		request.setSbwsEnabled(Constants.DEFAULT);
		request.setLeadSupervisorName(Constants.DEFAULT);
		request.setStayingInPg(Constants.DEFAULT);
		request.setTcsDesktop(Constants.DEFAULT);
		request.setTypeOfInternetConnection(Constants.DEFAULT);*/
		request.setStatus(STATUS_PENDING);
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = now.format(formatter);
		request.setCreatedBy(username);
		request.setCreatedOn(formatDateTime);
		try {
			boolean result = userDetailsDao.addUserAdmin(request);
			if (result) {
				return "User request created with the status of pending..";
			}
			else
			{
				return "User request already present";
			}
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return "user not created";
	}

}
