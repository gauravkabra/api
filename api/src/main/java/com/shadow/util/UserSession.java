package com.shadow.util;

/**
 * Model class that holds User Session details
 * 
 * @author Vsridhara
 *
 */
public class UserSession {

	private String name;
	private String userId;
	private long lastKnown;
	private int timeout;
	private String csrfToken;

	public UserSession(String name) {
		this.name = name;
		this.timeout = 10 * 60 * 1000;
		alive();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLastKnown() {
		return lastKnown;
	}

	public void setLastKnown(long lastKnown) {
		this.lastKnown = lastKnown;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public boolean isExpired() {
		return (System.currentTimeMillis() - lastKnown) > timeout;
	}

	public void alive() {
		lastKnown = System.currentTimeMillis();
	}

	/**
	 * @return the csrfToken
	 */
	public String getCsrfToken() {
		return csrfToken;
	}

	/**
	 * @param csrfToken
	 *            the csrfToken to set
	 */
	public void setCsrfToken(String csrfToken) {
		this.csrfToken = csrfToken;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
