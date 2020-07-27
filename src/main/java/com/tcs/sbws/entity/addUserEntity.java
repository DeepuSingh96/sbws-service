package com.tcs.sbws.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class addUserEntity {
	@Id
 	private String AccountName ;
	private String EmployeeId;
	private String EmployeeName;
	private String MailId;
	private String Role;
	
	
	public addUserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public addUserEntity(String accountName, String employeeId, String employeeName, String mailId, String role) {
		super();
		AccountName = accountName;
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		MailId = mailId;
		Role = role;
	}



	public String getAccountName() {
		return AccountName;
	}


	public void setAccountName(String accountName) {
		AccountName = accountName;
	}


	public String getEmployeeId() {
		return EmployeeId;
	}


	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}


	public String getEmployeeName() {
		return EmployeeName;
	}


	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}


	public String getMailId() {
		return MailId;
	}


	public void setMailId(String mailId) {
		MailId = mailId;
	}


	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}


	@Override
	public String toString() {
		return "addUserEntity [AccountName=" + AccountName + ", EmployeeId=" + EmployeeId + ", EmployeeName="
				+ EmployeeName + ", MailId=" + MailId + ", Role=" + Role + "]";
	}


	

}
