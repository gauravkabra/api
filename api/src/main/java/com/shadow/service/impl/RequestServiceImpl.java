package com.shadow.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.shadow.dao.LoginDao;
import com.shadow.dao.RequestDao;
import com.shadow.dao.impl.LoginDaoImpl;
import com.shadow.dao.impl.RequestDaoImpl;
import com.shadow.entity.AccountOpeningRequest;
import com.shadow.entity.User;
import com.shadow.model.AccountRequest;
import com.shadow.model.AllRequests;
import com.shadow.model.Request;
import com.shadow.service.RequestService;
import com.shadow.util.SendMessage;

public class RequestServiceImpl implements RequestService {

	private RequestDao requestDao;

	private LoginDao loginDao;

	@Override
	public AccountOpeningRequest saveRequest(AccountOpeningRequest request) {
		requestDao = new RequestDaoImpl();
		requestDao.saveRequest(request);
		return request;
	}

	@Override
	public AccountOpeningRequest updateRequest(AccountOpeningRequest request) {
		requestDao = new RequestDaoImpl();
		requestDao.updateRequest(request);
		return request;
	}

	@Override
	public AllRequests getAllRequests(String user) {
		requestDao = new RequestDaoImpl();
		List<AccountRequest> allRequests = new ArrayList<>();
		List<AccountOpeningRequest> requests = requestDao.getAllRequest(user);
		for (AccountOpeningRequest accountOpeningRequest : requests) {
			allRequests.add(mapRequest(accountOpeningRequest));
		}
		return null;
	}

	private AccountRequest mapRequest(AccountOpeningRequest auth) {
		AccountRequest request = new AccountRequest();
		request.setAadharNumber(auth.getAadharNumber());
		request.setAddress1(auth.getAddress1());
		request.setAddress2(auth.getAddress2());
		request.setAddress3(auth.getAddress3());
		request.setAlternateAddress(auth.getAlternateAddress());
		request.setContactNumber(auth.getContactNumber());
		request.setEmailId(auth.getEmailId());
		request.setFirstName(auth.getFirstName());
		request.setLastName(auth.getLastName());
		request.setNationality(auth.getNationality());
		request.setSalary(auth.getSalary());
		request.setStatus("PENDING");
		request.setUser(auth.getUser().getUserName());
		return null;
	}

	@Override
	public Request closeRequest(Request request) {
		// TODO Auto-generated method stub
		requestDao = new RequestDaoImpl();
		loginDao = new LoginDaoImpl();

		AccountOpeningRequest accountOpeningRequest = requestDao
				.getRequestById(request.getRequestId());
		User user = loginDao.getUser(accountOpeningRequest.getUser()
				.getUserName());
		accountOpeningRequest.setStatus(request.getStatus());
		if (request.getStatus().equals("SUCCESS")) {
			SendMessage message = new SendMessage();
			message.sendMessage(user.getContactNumber(),
					"Account Created Successfully");
		}
		requestDao.updateRequest(accountOpeningRequest);
		return request;
	}
}
