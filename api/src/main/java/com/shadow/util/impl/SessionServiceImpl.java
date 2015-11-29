package com.shadow.util.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadow.dao.LoginDao;
import com.shadow.entity.User;
import com.shadow.util.SessionIdGenerator;
import com.shadow.util.SessionMap;
import com.shadow.util.SessionService;
import com.shadow.util.UserSession;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	private SessionIdGenerator sessionIdGenerator;

	private SessionMap sessions;
	private Map<String, String> users;

	@Autowired
	private LoginDao loginDao;

	@PostConstruct
	public void initialize() {
		sessions = new SessionMap();
		users = new HashMap<String, String>();
	}

	@Override
	public String create(String userId) {
		// what if session already exists?
		// remove existing session?
		if (users.containsKey(userId)) {
			sessions.put(users.get(userId), null);
			users.put(userId, null);
		}

		String token = sessionIdGenerator.next();
		String csrfToken = sessionIdGenerator.next();
		UserSession session = new UserSession(userId);
		session.setUserId(userId);
		try {
			User user = loginDao.getUser(userId);
			if (null != user) {
				session.setName(user.getFirstName());
				session.setCsrfToken(csrfToken);
			}
		} catch (Exception e) {
			return null;
		}
		users.put(userId, token);
		sessions.put(token, session);

		return token;
	}

	@Override
	public UserSession getSession(String token) {
		return sessions.get(token);
	}

	@Override
	public boolean isExpired(String token) {

		UserSession session = getSession(token);
		if (session == null)
			return true;

		if (session.isExpired()) {
			sessions.put(token, null);
			users.put(session.getName(), null);
			return true;
		}

		return false;
	}

	@Override
	public void alive(String token) {
		UserSession session = getSession(token);
		if (session == null)
			return;

		session.alive();
	}

	@Override
	public void delete(String token) {
		if (sessions.containsKey(token)) {
			String userId = sessions.get(token).getUserId();
			users.put(userId, null);
			sessions.put(token, null);
		}
	}
}
