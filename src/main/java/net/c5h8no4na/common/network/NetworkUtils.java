package net.c5h8no4na.common.network;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;

public class NetworkUtils {

	private static HttpClient client = HttpClient.newBuilder().followRedirects(Redirect.ALWAYS).build();

	private NetworkUtils() {}

	public static String makeSimpleRequest(String url) throws IOException, InterruptedException {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response.body();
	}

	public static String getCurrentIp() throws IOException, InterruptedException {
		return makeSimpleRequest("https://ipinfo.io/ip");
	}

	public static String basicAuth(String username, String password) {
		return "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
	}

}
