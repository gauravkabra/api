package com.shadow.util.impl;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import com.shadow.util.HashingService;

/**
 * 
 * Implementation for methods in HashingService
 * 
 * @author Vsridhara
 *
 */
@Service
public class HashingServiceImpl implements HashingService {

	// NIST recommended Hashing algorithm
	private static String ALGORITHM = "PBKDF2WithHmacSHA1";
	// SHA1 Key length
	private static int KEY_LENGTH = 160;
	// Make cracking difficult
	private static int ITERATIONS = 20000;

	@Override
	public String hash(String password, String salt) {

		byte[] decodedSalt = DatatypeConverter.parseBase64Binary(salt);
		KeySpec keySpec = new PBEKeySpec(password.toCharArray(), decodedSalt, ITERATIONS, KEY_LENGTH);
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
			return DatatypeConverter.printBase64Binary(keyFactory.generateSecret(keySpec).getEncoded());
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
		}

		return null;
	}

	@Override
	public String salt() {

		try {
			SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
			byte[] salt = new byte[8];
			random.nextBytes(salt);

			return DatatypeConverter.printBase64Binary(salt);
		} catch (NoSuchAlgorithmException ex) {
		}

		return null;
	}
}
