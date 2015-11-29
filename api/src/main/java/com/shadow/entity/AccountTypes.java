package com.shadow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "ACCOUNT_TYPES")
public class AccountTypes {

	@Id
	@Column(name = "ACCOUNT_TYPE_ID")
	private int accountTypeId;

	private String name;

	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
