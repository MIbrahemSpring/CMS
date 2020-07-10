package com.mohamed.cms.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	private final Random RANDOM = new SecureRandom();
	private final String ALPHAPET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public String generateUserId(int length, String prefix) {
		return generateRandomString(length, prefix);
	}

	private String generateRandomString(int length, String prefix) {
		StringBuilder returnValue = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHAPET.charAt(RANDOM.nextInt(ALPHAPET.length())));
		}

		return new String(prefix + returnValue);
	}
}
