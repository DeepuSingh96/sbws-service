package com.tcs.sbws.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.tcs.sbws.entity.AccountEntity;
import com.tcs.sbws.entity.Testing;
import com.tcs.sbws.service.AccountService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.tcs.sbws.dao.UserDetailsDao;
import com.tcs.sbws.entity.UserDetailsEntity;
import com.tcs.sbws.service.UserDetailsService;

/*
 * Created by 1430208-Yamini S
 * Controller Class for UserDetails api which does logged-in user requires crud operations.
 * Changes - Account Base
 */

@CrossOrigin(origins = "*")
@RestController
public class UserDetailsController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AccountService accountService;

	@PostMapping("/dashboard/{username}/usersDetails")
	public String addEmployeeDetails(@PathVariable String username, @RequestBody UserDetailsEntity userDetails) {

		try {
			if(username!="")
			{
				//Get current date time
		        LocalDateTime now = LocalDateTime.now();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		        String formatDateTime = now.format(formatter);
				userDetails.setCreatedBy(username);
				userDetails.setCreatedOn(formatDateTime);
				return userDetailsService.addUser(userDetails);
			}
			
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}
//Changes -start-done by -yamini
	//1.Get admin request
    @PostMapping("/dashboard/{username}/adminRequest")
    public String addRequestAdmin(@PathVariable String username, @RequestBody UserDetailsEntity userDetails) {

        try {
            if(username!="")
            {
                //Get current date time
                return userDetailsService.addUserAdmin(username,userDetails);
            }

        } catch (Exception e) {
            logger.error("Exception thrown for incorrect algorithm: " + e);
        }
        return null;
    }
    //2.Get data for completed,pending,deleted etc status
	@GetMapping("/dashboard/{username}/{status}")
	public List<UserDetailsEntity> getUserStatus(@PathVariable String status) {
		try {
			logger.info(status);
			return userDetailsDao.getUserStatus(status);
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}
  //3.Updated changes based on admin base updation in future
	@GetMapping("/dashboard/{username}/allEmployeeDetails")
	public List<UserDetailsEntity> getAllEmployeeDetails(@PathVariable String username) {
		try {
			logger.info(username);
			return userDetailsDao.getAllUsers();
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}

		return null;
	}
	
	@GetMapping("/dashboard/{username}/allEmployeeDetails/deletedStatus")
	public List<UserDetailsEntity> getAllDeletedStatusEmployeeDetails(@PathVariable String username) {
		try {
			logger.info(username);
			return userDetailsDao.getDeleteAllUsers();
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}

		return null;
	}
	
	@GetMapping("/dashboard/{username}/allEmployeeDetails/pendingStatus")
	public List<UserDetailsEntity> getAllPendingStatusEmployeeDetails(@PathVariable String username) {
		try {
			logger.info(username);
			return userDetailsDao.getPendingAllUsers();
		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}

		return null;
	}
	
	@PutMapping("/dashboard/{username}/usersDetails/{employeeNo}")
	public UserDetailsEntity updateEmployeeDetails(@PathVariable String username, @PathVariable String employeeNo,
			@RequestBody UserDetailsEntity userDetails) {

		try {

			return userDetailsDao.update(employeeNo, userDetails);
		}

		catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}

	@DeleteMapping("/dashboard/{username}/removeUsersDetails/{employeeNo}")
	public String deleteTodo(@PathVariable String username, @PathVariable String employeeNo) {

		return userDetailsDao.deleteByOne(username,employeeNo);

	}

	/*
	 * Account Class Changes
	 *
	 * Adding user account details - method:POST path:/addAccountUser Retrieve
	 * access details - method:GET path:/dashboard/{accountId}/allUserDetails
	 *
	 */

	@PostMapping("/addAccountUser")
	public String addAccountUser(@RequestBody AccountEntity accountEntity) {

		try {
			return accountService.addAccountUser(accountEntity);
		} catch (Exception e) {
			System.out.println("Exception thrown for incorrect algorithm: " + e);
		}
		return null;
	}

	@GetMapping("/dashboard/{accountId}/allUserDetails")
	public List<UserDetailsEntity> getAllEmployeeDetailsAccount(@PathVariable int accountId) {
		try {
			logger.info("account id:: " + accountId);

			boolean result = accountService.accountAccess(accountId);

			if (result) {
				return userDetailsDao.getAllUsers();
			}

		} catch (Exception e) {
			logger.error("Exception thrown for incorrect algorithm: " + e);
		}

		return null;
	}
}
