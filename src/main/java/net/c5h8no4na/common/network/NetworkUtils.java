package net.c5h8no4na.common.network;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class NetworkUtils {

	private static HttpClient client = HttpClient.newBuilder().followRedirects(Redirect.ALWAYS).build();

	private NetworkUtils() {}

	public static String makeSimpleRequest(String url) {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		try {
			HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
			return response.body();

		} catch (IOException | InterruptedException e) {
			return null;
		}
	}

	public static String getCurrentIp() {
		return makeSimpleRequest("https://ipinfo.io/ip");
	}

}
