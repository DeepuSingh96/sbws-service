package com.tcs.sbws.vo;

public class LoginResponse {

	private final String jwt ;
	private final String roles ;
	public String getEmployeeName() {
		return employeeName;
	}



	private final String accountName;
	private final String employeeName;
	
	
	public String getAccountName() {
		return accountName;
	}



	public LoginResponse(String jwt,String roles,String accountName,String employeeName) {
		super();
		this.jwt = jwt;
		this.roles=roles;
		this.accountName = accountName;
		this.employeeName = employeeName;
	}



	public String getJwt()
	{
		return jwt;
	}



	public String getRoles() {
		return roles;
	}
}
