package net.c5h8no4na.common.network;

import java.net.http.HttpClient;
import java.net.http.HttpRequest.Builder;
import java.util.Base64;

public abstract class ApiClient<T> {

	protected HttpClient client;

	public ApiClient() {
		client = getHttpClient();
	}

	protected abstract HttpClient getHttpClient();

	protected abstract Builder getBuilderBase();

	protected abstract <U> NetworkRequest<T> get(String url);

	public static String basicAuth(String username, String password) {
		return "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
	}
}
