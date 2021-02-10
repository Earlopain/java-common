package net.c5h8no4na.common.network;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest.Builder;
import java.util.Base64;

public abstract class ApiClient<T> {

	protected HttpClient client;

	public ApiClient() {
		this.client = HttpClient.newHttpClient();
	}

	protected abstract Builder getBuilderBase();

	public abstract NetworkRequest<T> get(URI url);

	public static String basicAuth(String username, String password) {
		return "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
	}
}
