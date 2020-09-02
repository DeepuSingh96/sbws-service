package com.tcs.sbws.vo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.tcs.sbws.entity.UserEntity;

public class MyUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private boolean active;
	private String accountName;
	private List<GrantedAuthority> authorities;
	private String employeeName;

	public MyUserDetails(UserEntity user) {
		this.userName = user.getEmployeeNo();
		this.password = user.getPassword();
		this.accountName = user.getAccountName();
		this.employeeName = user.getEmployeeName();
		this.active = user.isActive();
		this.authorities = Arrays.stream(user.getRoles().split(",")).
							map(SimpleGrantedAuthority::new).
							collect(Collectors.toList());
	}
	
	public MyUserDetails() {
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}



	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
	
	
}
