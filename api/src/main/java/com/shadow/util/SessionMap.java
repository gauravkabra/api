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

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * All session handling methods are implemented here
 * 
 * @author Vsridhara
 *
 */
public class SessionMap extends LinkedHashMap<String, UserSession> {

	private static final long serialVersionUID = -4610914999902389570L;

	@Override
	protected boolean removeEldestEntry(Map.Entry<String, UserSession> eldest) {

		if (eldest != null && eldest.getValue() != null)
			return eldest.getValue().isExpired();

		return super.removeEldestEntry(eldest);
	}
}
