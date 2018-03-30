package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.pagala.JShikiApi.Items.AccessToken;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * Created by firely-pasha on 7/11/17.
 */

@SuppressWarnings({"unused", "Duplicates", "MismatchedQueryAndUpdateOfCollection"})
public final class Shikimori {

	/**
	 * Site domain
	 */
    public static final String SITE_DOMAIN;

	/**
	 * API domain
	 */
    public static final String API_DOMAIN;

    private static RequestVersion requestVersion;

    private static String clientId;

    private static String clientSecret;

    private static String redirectUri;

    private static String accessToken;

    private static String appName;

    private static String developerName;

    static ObjectMapper mapper;

    private static boolean showResponse;

    private static HttpClient client;

    private static AccessToken currentToken;

    static {
        SITE_DOMAIN = "https://shikimori.org";
        API_DOMAIN  = SITE_DOMAIN + "/api";
        mapper = new ObjectMapper();
	    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        client = HttpClients.createDefault();
        appName = null;
        accessToken = null;
        requestVersion = RequestVersion.API_V1;
        showResponse = false;
	    developerName = "Firely-Pasha";
    }

    private Shikimori() {

    }

    private static JsonNode getRequest(String stringUrl) {
        HttpGet httpGet;
        try {
            httpGet = new HttpGet(buildUri(stringUrl));
	        return request(httpGet, true);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    static JsonNode postRequest(String stringUrl, String arg, boolean readResponse) {
        HttpPost httpPost;
        try {
            httpPost = new HttpPost(buildUri(stringUrl));
            if (arg != null) {
                httpPost.setEntity(new StringEntity(arg));
            }
            httpPost.addHeader("Content-Type", "application/json");
	        return request(httpPost, readResponse);
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO: Make return notice for some methods.
    static JsonNode deleteRequest(String stringUrl, boolean readResponse) {
        HttpDelete httpDelete;
        try {
            httpDelete = new HttpDelete(buildUri(stringUrl));
	        return request(httpDelete, readResponse);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    static JsonNode putRequest(String stringUrl, String arg, boolean readResponse) {
        HttpPut httpPut;
        try {
            httpPut = new HttpPut(buildUri(stringUrl));
            httpPut.setEntity(new StringEntity(arg));
            httpPut.addHeader("Content-Type", "application/json");
	        return request(httpPut, readResponse);
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO: Token expired error!!!!
    private static JsonNode request(final HttpUriRequest request, final boolean readResponse) {
        request.setHeader("User-Agent", (appName == null ? "JShikiApi" : appName) + " " + developerName);
        if (accessToken != null) {
	        request.setHeader("Authorization", "Bearer " + accessToken);
        }
	    ExecutorService executor = Executors.newSingleThreadExecutor();

	    final JsonNode[] jsonResponse = {null};
	    Future<HttpResponse> result = executor.submit(() -> {
            HttpResponse response = client.execute(request);
            System.out.println("Request: " + request.getURI().toString() + "\n" +
                    "Response: " +
                    response.getStatusLine().getStatusCode() + " (" + response.getStatusLine().getReasonPhrase() + ")");
            if (readResponse) {
                jsonResponse[0] = mapper.readTree(response.getEntity().getContent());
            }
            if (showResponse) {
                System.out.println(getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(jsonResponse[0]));
            }
            return response;
	    });

	    while (!result.isDone());
	    executor.shutdown();

	    return jsonResponse[0];
    }

    private static URI buildUri(String stringUri) throws URISyntaxException {
        URI uri = null;
        switch (requestVersion) {
            case API_V1:
                uri = new URI(API_DOMAIN + stringUri);
                break;
            case API_V2:
                uri = new URI(API_DOMAIN + "/v2" + stringUri);
                break;
	        case SITE:
	        	uri = new URI(SITE_DOMAIN + stringUri);
        }
        requestVersion = RequestVersion.API_V1;
        return uri;
    }

    static void switchApiVersion(RequestVersion requestVersion) {
        Shikimori.requestVersion = requestVersion;
    }

    static <T> T getItem(String url, Class<T> tClass) {
        JsonNode jsonItem = getRequest(url);
        T t = null;
        try {
            t = mapper.treeToValue(jsonItem, tClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return t;
    }

	static <T> T postItem(String url, String arg, Class<T> tClass, boolean readResponse) {
		JsonNode jsonItem = postRequest(url, arg, readResponse);
		T t = null;
		try {
			t = mapper.treeToValue(jsonItem, tClass);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return t;
	}

	static <T> T putItem(String url, String arg, Class<T> tClass, boolean readResponse) {
		JsonNode jsonItem = putRequest(url, arg, readResponse);
		T t = null;
		try {
			t = mapper.treeToValue(jsonItem, tClass);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return t;
	}

    static <T> List<T> getItemList(String url, Class<T[]> tClass) {
        T[] items = getItem(url, tClass);
        if (items == null) {
            return  new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(items));
    }

    public static void setClientId(String clientId) {
        Shikimori.clientId = clientId;
    }

	public static void setClientSecret(String clientSecret) {
    	Shikimori.clientSecret = clientSecret;
    }

	public static void setRedirectUri(String redirectUri) {
    	Shikimori.redirectUri = redirectUri;
    }

	public static AccessToken requestAccessToken(String authorizationCode) {
    	if (clientId != null && clientSecret != null &&
		    authorizationCode != null && redirectUri != null) {
		    ObjectNode objectNode = getObjectMapper().createObjectNode();
		    objectNode.put("grant_type", "authorization_code");
		    objectNode.put("client_id", clientId);
		    objectNode.put("client_secret", clientSecret);
		    objectNode.put("code", authorizationCode);
		    objectNode.put("redirect_uri", redirectUri);
		    switchApiVersion(RequestVersion.SITE);
		    JsonNode response = postRequest("/oauth/token", objectNode.toString(), true);
		    currentToken = getObjectMapper().convertValue(response, AccessToken.class);
		    accessToken = currentToken.getAccessToken();
		    return currentToken;
	    } else {
    		return null;
	    }
    }

	public static String getAccessToken() {
		return accessToken;
	}

	public static void setAccessToken(String accessToken) {
    	Shikimori.accessToken = accessToken;
    }

    public static AccessToken refreshToken(String refreshToken) {
	    if (clientId != null && clientSecret != null &&
            refreshToken != null && redirectUri != null) {
            ObjectNode objectNode = getObjectMapper().createObjectNode();
            objectNode.put("grant_type", "refresh_token");
            objectNode.put("client_id", clientId);
            objectNode.put("client_secret", clientSecret);
            objectNode.put("refresh_token", refreshToken);
            objectNode.put("redirect_uri", redirectUri);
            switchApiVersion(RequestVersion.SITE);
            JsonNode response = postRequest("/oauth/token", objectNode.toString(), true);
            currentToken = getObjectMapper().convertValue(response, AccessToken.class);
            accessToken = currentToken.getAccessToken();
            return currentToken;
        }
	    return null;
    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }

    public static void showResponse(boolean showResponse) {
    	Shikimori.showResponse = showResponse;
    }

	public static AccessToken getCurrentToken() {
		return currentToken;
	}

	public static boolean isAuthorized() {
        return accessToken == null;
    }

    public static boolean isTokenExpired() {
    	if (currentToken == null) {
		    return true;
	    } else {
    		long absoluteExpiration = currentToken.getCreatedAt().getTime() + currentToken.getExpiresIn() * 1000;
		    System.out.println(currentToken.getCreatedAt());
    		return absoluteExpiration < new Date().getTime() + 23 * 60 * 60 * 1000;
	    }
    }

    private enum RequestMethod {
        GET,
        POST,
        PUT,
        DELETE;

        @Override
        public String toString() {
            return name();
        }
    }

    enum RequestVersion {
	    API_V1,
	    API_V2,
	    SITE
    }
}
