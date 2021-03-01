package net.c5h8no4na.common;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import net.c5h8no4na.common.assertion.Assert;

public class ServerConfig {
	private ServerConfig() {}

	public static String getCloudflareApiKey() {
		return getFromContext("config/cloudflareApiKey");
	}

	public static String getCloudflareZoneId() {
		return getFromContext("config/cloudflareZoneId");
	}

	@SuppressWarnings("unchecked")
	private static <T> T getFromContext(String path) {
		try {
			Context ctx = new InitialContext();
			return (T) ctx.lookup(path);
		} catch (NamingException e) {
			e.printStackTrace();
			Assert.notReached();
			return null;
		}
	}
}
