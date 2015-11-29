package com.shadow.service;

import com.shadow.entity.User;

public interface LoginService {

	User getUser(String user);

	String addUser(User user);
}
