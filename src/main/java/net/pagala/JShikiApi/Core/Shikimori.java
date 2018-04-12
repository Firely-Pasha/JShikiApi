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
    private static int responseCode;
    private static JsonNode siteError;
    private static Exception exception;

    static {
        SITE_DOMAIN = "https://shikimori.org";
        API_DOMAIN  = SITE_DOMAIN + "/api";
        requestVersion = RequestVersion.API_V1;
        clientId = null;
        clientSecret = null;
        redirectUri = null;
        accessToken = null;
        appName = null;
        developerName = null;
        mapper = new ObjectMapper();
        showResponse = false;
        client = HttpClients.createDefault();
        currentToken = null;
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private Shikimori() {

    }

    private static JsonNode runRequest(HttpUriRequest request, boolean readResponse) throws IOException {
        HttpResponse response = client.execute(request);
        responseCode = response.getStatusLine().getStatusCode();
        System.out.println("Request: " + request.getURI().toString() + "\n" +
                "Response: " + responseCode + " (" + response.getStatusLine().getReasonPhrase() + ")");
        if (readResponse) {
            JsonNode jsonResponse = mapper.readTree(response.getEntity().getContent());
            if (showResponse) {
                System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonResponse));
            }
            return jsonResponse;
        }
        return null;
    }

    //TODO: Token expired error!!!!
    private static JsonNode request(final HttpUriRequest request, final boolean readResponse) {
        siteError = null;
        exception = null;
        responseCode = -1;
        request.setHeader("User-Agent", (appName == null ? "JShikiApi" : appName) + " " + developerName);
        if (accessToken != null) {
            request.setHeader("Authorization", "Bearer " + accessToken);
        }
        try {
            return runRequest(request, readResponse);
        } catch (IOException e) {
            exception = e;
        }
        return null;
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

    private static JsonNode getRequest(String stringUrl) {
        HttpGet httpGet;
        try {
            httpGet = new HttpGet(buildUri(stringUrl));
            return request(httpGet, true);
        } catch (URISyntaxException e) {
            exception = e;
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
            exception = e;
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
            exception = e;
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
            exception = e;
        }
        return null;
    }

    private static <T> T handleItem(JsonNode jsonItem, Class<T> tClass) {
        if (jsonItem == null) {
            return null;
        }
        if (getResponseCode() >= 400) {
            siteError = jsonItem;
            return null;
        }
        T t = null;
        try {
            t = mapper.treeToValue(jsonItem, tClass);
        } catch (JsonProcessingException e) {
            siteError = jsonItem;
        }
        return t;
    }

    static <T> T getItem(String url, Class<T> tClass) {
        JsonNode jsonItem = getRequest(url);
        return handleItem(jsonItem, tClass);
    }

    static <T> T postItem(String url, String arg, Class<T> tClass, boolean readResponse) {
        JsonNode jsonItem = postRequest(url, arg, readResponse);
        return handleItem(jsonItem, tClass);
    }

    static <T> T putItem(String url, String arg, Class<T> tClass, boolean readResponse) {
        JsonNode jsonItem = putRequest(url, arg, readResponse);
        return handleItem(jsonItem, tClass);
    }

    static <T> T deleteItem(String url, Class<T> tClass, boolean readResponse) {
        JsonNode jsonItem = deleteRequest(url, readResponse);
        return handleItem(jsonItem, tClass);
    }

    static <T> List<T> getItemList(String url, Class<T[]> tClass) {
        T[] items = getItem(url, tClass);
        if (items == null) {
            return null;
        }
        return new ArrayList<>(Arrays.asList(items));
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

    public static void setClientId(String clientId) {
        Shikimori.clientId = clientId;
    }

    public static void setClientSecret(String clientSecret) {
        Shikimori.clientSecret = clientSecret;
    }

    public static void setRedirectUri(String redirectUri) {
        Shikimori.redirectUri = redirectUri;
    }

    public static String getAccessToken() {
        return accessToken;
    }

    public static void setAccessToken(String accessToken) {
        Shikimori.accessToken = accessToken;
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
        return accessToken != null;
    }

    public static boolean isTokenExpired() {
        if (currentToken == null) {
            return true;
        } else {
            long absoluteExpiration = currentToken.getCreatedAt().getTime() + currentToken.getExpiresIn() * 1000;
            System.out.println(currentToken.getCreatedAt());
            return absoluteExpiration < new Date().getTime();
        }
    }

    public static int getResponseCode() {
        return responseCode;
    }

    public static JsonNode getSiteError() {
        return siteError;
    }

    public static Exception getException() {
        return exception;
    }

    public static boolean isRequestSuccessful() {
        boolean queryStatus = responseCode < 300;
        return queryStatus && siteError == null && exception == null;
    }

    public static void setDeveloperName(String developerName) {
        Shikimori.developerName = developerName;
    }

    public static void setAppName(String appName) {
        Shikimori.appName = appName;
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
