package com.shadow.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AllRequests {

	private List<AccountRequest> request;

	public List<AccountRequest> getRequest() {
		return request;
	}

	public void setRequest(List<AccountRequest> request) {
		this.request = request;
	}

}
