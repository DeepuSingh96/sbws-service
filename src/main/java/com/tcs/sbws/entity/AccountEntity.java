package com.tcs.sbws.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/*
 * Created by 1430208-Yamini S
 * Entity Class for Account.
 */

@Document
public class AccountEntity {

	private int accountId;
	private String accountName;

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
