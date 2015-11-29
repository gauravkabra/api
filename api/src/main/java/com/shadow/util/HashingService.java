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
 * All the methods related to Hashing
 * 
 * @author Vsridhara
 *
 */
public interface HashingService {

	/**
	 * Returns hash value for the combination of password and salt
	 * 
	 * @param password
	 * @param salt
	 * @return
	 */
	String hash(String password, String salt);

	/**
	 * Returns new salt value
	 * 
	 * @return
	 */
	String salt();
}
