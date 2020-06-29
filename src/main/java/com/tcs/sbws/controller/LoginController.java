package com.tcs.sbws.controller;

import com.tcs.sbws.entity.LoginEntity;
import com.tcs.sbws.service.LoginService;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class LoginController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoginService loginService;

//    @PostMapping("/test")
//    public LoginEntity test()
//    {
//    	System.out.println("Test1234");
//    	return new LoginEntity("Test1234");
//    }
//    
    

	@PostMapping( "/addUser") // just remove the line @RequestBody com.tcs.sbws.entity.LoginEntity login,
    public String addUser(@RequestHeader HttpHeaders headers) {
        LOG.info("Saving user.");
        try
        {
        	String value = headers.getFirst(HttpHeaders.AUTHORIZATION);
    		System.out.println(value);
    		System.out.println(value.substring(6));
    		byte[] decodedBytes = Base64.getDecoder().decode(value.substring(6));
    		String decodedString = new String(decodedBytes);
    		System.out.println(decodedString);
    			String arr1[] = decodedString.split(":");
    			//System.out.println(arr1[0]);
    			String employeeNo = arr1[0];
    			String password =	arr1[1];
    			//System.out.println(arr1[1]);
    			System.out.println("Array of --1"+arr1[0]);
    			System.out.println("Array of --2"+arr1[1]);
    			LoginEntity login1 = new LoginEntity();
        		login1.setEmployeeNo(employeeNo);
        		login1.setPassword(password);
            return loginService.addUser(login1);

        }
        // For specifying wrong message digest algorithms
        catch (Exception e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        return null;
    }
    @PostMapping( "/login")// just remove the line @RequestBody com.tcs.sbws.entity.LoginEntity login,
    public String userLogin(@RequestHeader HttpHeaders headers) {
        LOG.info("Saving user.");
        try
        {
        	String value = headers.getFirst(HttpHeaders.AUTHORIZATION);
    		System.out.println(value);
    		System.out.println(value.substring(6));
    		byte[] decodedBytes = Base64.getDecoder().decode(value.substring(6));
    		String decodedString = new String(decodedBytes);
    		System.out.println(decodedString);
    			String arr1[] = decodedString.split(":");
    			//System.out.println(arr1[0]);
    			String employeeNo = arr1[0];
    			String password =	arr1[1];
    			//System.out.println(arr1[1]);
    			System.out.println("Array of --1"+arr1[0]);
    			System.out.println("Array of --2"+arr1[1]);
    		LoginEntity login1 = new LoginEntity();
    		login1.setEmployeeNo(employeeNo);
    		login1.setPassword(password);
            return loginService.login(login1);
        }
        // For specifying wrong message digest algorithms
        catch (Exception e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        return null;
    }


}
