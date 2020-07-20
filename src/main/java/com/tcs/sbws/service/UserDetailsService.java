package com.tcs.sbws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tcs.sbws.dao.UserDetailsDao;

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
				return "user created";
			}
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return "user not created";
	}

}
