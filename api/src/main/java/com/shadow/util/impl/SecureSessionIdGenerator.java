package com.shadow.util.impl;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import com.shadow.util.SessionIdGenerator;

/**
 * Implementation for methods in SessionIdGenerator
 * 
 * @author Vsridhara
 *
 */
@Service
public class SecureSessionIdGenerator implements SessionIdGenerator {

	private SecureRandom random = new SecureRandom();

	@Override
	public String next() {
		return new BigInteger(130, random).toString(32);
	}
}
