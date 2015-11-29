package com.shadow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Configuration {

	@Id
	@Column(name = "CONFIG_ID")
	private int configId;

	private String name;

	@ManyToOne
	@JoinColumn(name = "LOGIN_ID")
	private User user;

	public int getConfigId() {
		return configId;
	}

	public void setConfigId(int configId) {
		this.configId = configId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
