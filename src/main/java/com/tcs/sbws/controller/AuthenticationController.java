package com.tcs.sbws.controller;

import com.tcs.sbws.entity.UserEntity;
import com.tcs.sbws.repository.UsersRepository;
import com.tcs.sbws.service.UserService;
import com.tcs.sbws.utils.EncryptionUtil;
import com.tcs.sbws.utils.JwtUtil;
import com.tcs.sbws.vo.LoginResponse;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
* Created by 1430208-Yamini S
* Controller Class for login api which performs operations adding and login user.
*/

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

//	@Autowired
//	private MyUserDetailsService myUserDetailsService;  

	@Autowired
	private UserService userService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserEntity authenticationRequest) throws Exception {

		final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getEmployeeNo());

		EncryptionUtil e = new EncryptionUtil();
		if (!userDetails.getPassword().contains(e.encryptText(authenticationRequest.getPassword()))) {
			return ResponseEntity.badRequest().build();
		}
		// System.out.println(userDetails);
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) userDetails.getAuthorities();
		String roles = "";
		for (GrantedAuthority authority : authorities) {
			roles = authority.getAuthority();
		}

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new LoginResponse(jwt, roles,"Standard life"));

	}
}
