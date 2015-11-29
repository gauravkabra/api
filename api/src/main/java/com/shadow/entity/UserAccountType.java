package com.shadow.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAccountType {

	@Id
	private int userId;
	private int accountTypeId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

}
