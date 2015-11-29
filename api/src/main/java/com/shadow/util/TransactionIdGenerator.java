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
 * Methods related to Transaction Id , Merchant Id are defined here
 * 
 * @author Vsridhara
 *
 */
public interface TransactionIdGenerator {
	/**
	 * Returns the next transaction Id of fixed length 14
	 * 
	 * @return
	 */
	String next();

	/**
	 * Returns the next transaction Id of the specified length
	 * 
	 * @param length
	 * @return
	 */
	String next(int length);

	/**
	 * Prepares the Merchant Id based on ACP spec for the merchant username sent
	 * 
	 * @param merchantUsername
	 * @return
	 */
	String nextMerchantTID(String merchantUsername);
}
