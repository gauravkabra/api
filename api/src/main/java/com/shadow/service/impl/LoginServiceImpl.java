package com.shadow.service.impl;

import com.shadow.dao.LoginDao;
import com.shadow.dao.impl.LoginDaoImpl;
import com.shadow.entity.User;
import com.shadow.service.LoginService;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	@Override
	public User getUser(String user) {
		loginDao = new LoginDaoImpl();
		User user2 = loginDao.getUser(user);
		return user2;
	}

	@Override
	public String addUser(User user) {
		loginDao = new LoginDaoImpl();
		String saveUser = loginDao.saveUser(user);
		return saveUser;
	}

}
