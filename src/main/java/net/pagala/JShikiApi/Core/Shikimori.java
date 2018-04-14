package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.pagala.JShikiApi.Items.OAuthToken;
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
    private static OAuthToken oAuthToken;
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
        oAuthToken = null;
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

    private static JsonNode request(final HttpUriRequest request, final boolean readResponse) {
        siteError = null;
        exception = null;
        responseCode = -1;
        request.setHeader("Content-Type", "application/json");
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
            return request(httpPost, readResponse);
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            exception = e;
        }
        return null;
    }

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
        if (getResponseCode() >= 300) {
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

    /**
     * Запрашивает новый токен.
     * @param authorizationCode код авторизации.
     * @return новый токен.
     */
    public static OAuthToken requestAccessToken(String authorizationCode) {
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
            oAuthToken = getObjectMapper().convertValue(response, OAuthToken.class);
            accessToken = oAuthToken.getAccessToken();
            return oAuthToken;
        } else {
            return null;
        }
    }

    /**
     * Обновляет токен.
     * @param refreshToken токен обновления токена.
     * @return обновленный токен.
     */
    public static OAuthToken refreshToken(String refreshToken) {
        if (clientId != null && clientSecret != null && refreshToken != null) {
            ObjectNode objectNode = getObjectMapper().createObjectNode();
            objectNode.put("grant_type", "refresh_token");
            objectNode.put("client_id", clientId);
            objectNode.put("client_secret", clientSecret);
            objectNode.put("refresh_token", refreshToken);
            switchApiVersion(RequestVersion.SITE);
            JsonNode response = postRequest("/oauth/token", objectNode.toString(), true);
            oAuthToken = getObjectMapper().convertValue(response, OAuthToken.class);
            accessToken = oAuthToken.getAccessToken();
            return oAuthToken;
        }
        return null;
    }

    /**
     * Инициализирует Client ID.
     * @param clientId Client ID.
     */
    public static void setClientId(String clientId) {
        Shikimori.clientId = clientId;
    }

    /**
     * Инициализирует Client Secret.
     * @param clientSecret - Client Secret.
     */
    public static void setClientSecret(String clientSecret) {
        Shikimori.clientSecret = clientSecret;
    }

    /**
     * Инициализирует URI для перенаправления.
     * @param redirectUri URI для перенаправления.
     */
    public static void setRedirectUri(String redirectUri) {
        Shikimori.redirectUri = redirectUri;
    }

    /**
     * Возвращает токен доступа.
     * @return токен доступа.
     */
    public static String getAccessToken() {
        return accessToken;
    }

    /**
     * Инициализирует токен доступа.
     * @param accessToken токен доступа.
     */
    public static void setAccessToken(String accessToken) {
        Shikimori.accessToken = accessToken;
    }

    /**
     * Возвращает {@link ObjectMapper}.
     */
    public static ObjectMapper getObjectMapper() {
        return mapper;
    }

    /**
     * Указывает, показывать ли ответ в консоли.
     */
    public static void showResponse(boolean showResponse) {
        Shikimori.showResponse = showResponse;
    }

    /**
     * Возвращает OAuthToken.
     */
    public static OAuthToken getOAuthToken() {
        return oAuthToken;
    }

    /**
     * Проверяет, авторизирован ли пользователь.
     */
    public static boolean isAuthorized() {
        return accessToken != null;
    }

    /**
     * Проверяет, истек ли срок действия токена.
     * <p>
     * Возвращает <code>true</code>, если пользователь не авторизирован.
     */
    public static boolean isTokenExpired() {
        if (oAuthToken == null) {
            return true;
        } else {
            long absoluteExpiration = oAuthToken.getCreatedAt().getTime() + oAuthToken.getExpiresIn() * 1000;
            return absoluteExpiration < new Date().getTime();
        }
    }

    /**
     * Возвращает код состояния ответа (HTTP).
     */
    public static int getResponseCode() {
        return responseCode;
    }

    /**
     * Возвращает ошибку сайта.
     * <p>
     * Обновляется после каждого запроса.
     */
    public static JsonNode getSiteError() {
        return siteError;
    }
    /**
     * Возвращает исключение API.
     * <p>
     * Обновляется после каждого запроса.
     */
    public static Exception getException() {
        return exception;
    }

    /**
     * Проверяет, успешен ли запрос.
     */
    public static boolean isRequestSuccessful() {
        boolean queryStatus = responseCode < 300;
        return queryStatus && siteError == null && exception == null;
    }

    /**
     * Инициализирует имя разработчика.
     * @param developerName имя разработчика
     */
    public static void setDeveloperName(String developerName) {
        Shikimori.developerName = developerName;
    }


    /**
     * Инициализирует название программы.
     * <p>
     * По умолчанию - <code>null</code>.
     * @param appName название программы
     */
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
