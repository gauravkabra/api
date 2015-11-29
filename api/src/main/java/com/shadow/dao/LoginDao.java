package com.shadow.dao;

import com.shadow.entity.User;

public interface LoginDao {

	public User getUser(String userName);

	public String saveUser(User user);

}
