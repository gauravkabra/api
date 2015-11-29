package com.shadow.service;

import com.shadow.entity.AccountOpeningRequest;
import com.shadow.model.AllRequests;
import com.shadow.model.Request;

public interface RequestService {

	public AccountOpeningRequest saveRequest(AccountOpeningRequest request);

	public AccountOpeningRequest updateRequest(AccountOpeningRequest request);

	public AllRequests getAllRequests(String user);

	public Request closeRequest(Request request);

}
