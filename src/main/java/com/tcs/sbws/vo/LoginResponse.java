package com.tcs.sbws.vo;

public class LoginResponse {

	private final String jwt ;
	private final String roles ;
	private final String accountName;
	
	
	public String getAccountName() {
		return accountName;
	}



	public LoginResponse(String jwt,String roles,String accountName) {
		super();
		this.jwt = jwt;
		this.roles=roles;
		this.accountName = accountName;
	}



	public String getJwt()
	{
		return jwt;
	}



	public String getRoles() {
		return roles;
	}
}
