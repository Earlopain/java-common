package net.c5h8no4na.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import net.c5h8no4na.common.assertion.Assert;

public class Hash {
	private Hash() {}

	public static String getMd5(byte[] input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return toHexString(md.digest(input));
		} catch (NoSuchAlgorithmException e) {
			Assert.notReached();
			return null;
		}
	}

	static String toHexString(byte[] bytes) {
		StringBuilder hexString = new StringBuilder();
		for (byte element : bytes) {
			String hex = Integer.toHexString(0xFF & element);
			if (hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}

}
