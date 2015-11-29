package com.shadow.dao;

import java.util.List;

import com.shadow.entity.AccountOpeningRequest;

public interface RequestDao {

	public AccountOpeningRequest saveRequest(AccountOpeningRequest request);

	public AccountOpeningRequest updateRequest(AccountOpeningRequest request);

	public List<AccountOpeningRequest> getAllRequest(String user);

	public AccountOpeningRequest getRequestById(Integer requestId);
}
