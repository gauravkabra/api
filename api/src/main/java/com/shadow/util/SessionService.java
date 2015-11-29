/*******************************************************************************
 * Copyright © Visa 2015. All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of Visa. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms and conditions
 * entered into with Visa.
 * 
 * @Author VinayakaS
 ******************************************************************************/
package com.shadow.util;

/**
 * All the session related services are declared here
 * 
 * @author Vsridhara
 *
 */
public interface SessionService {

	/**
	 * Creates session for the logged in user
	 * 
	 * @param userId
	 * @return session token
	 */
	String create(String userId);

	/**
	 * Returns session for the token
	 * 
	 * @param token
	 * @return
	 */
	UserSession getSession(String token);

	/**
	 * Returns true if session has expired else returns false
	 * 
	 * @param token
	 * @return
	 */
	boolean isExpired(String token);

	/**
	 * Checks if session is alive or not
	 * 
	 * @param token
	 */
	void alive(String token);

	/**
	 * Deletes or invalidates a session
	 * 
	 * @param token
	 */
	void delete(String token);
}
