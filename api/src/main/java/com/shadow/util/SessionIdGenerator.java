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
 * 
 * Interface for methods related to session Id
 * 
 * @author Vsridhara
 *
 */
public interface SessionIdGenerator {
	/**
	 * Returns the next session Id
	 * 
	 * @return
	 */
	String next();
}
