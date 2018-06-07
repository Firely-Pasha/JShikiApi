package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.pagala.JShikiApi.Items.OAuthToken;
import net.pagala.JShikiApi.Items.SignUpInfo;
import okhttp3.*;
//import org.apache.http.HttpResponse;
//import org.apache.http.CLIENT.HttpClient;
//import org.apache.http.CLIENT.methods.*;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.CLIENT.HttpClients;


/**
 *
 * Created by firely-pasha on 7/11/17.
 */

@SuppressWarnings({"unused", "Duplicates", "MismatchedQueryAndUpdateOfCollection"})
public final class Shikimori {

    public static final String SITE_DOMAIN;
    public static final String API_DOMAIN;
    public static final String API_V2_DOMAIN;

    private static final OkHttpClient CLIENT;
    private static final MediaType JSON_MEDIA_TYPE;

    private static String clientId;
    private static String clientSecret;
    private static String appName;
    private static String developerName;
    private static String accessToken;
    private static String redirectUrl;

    private static boolean showResponse;
    private static boolean showRequestUrl;

    static ObjectMapper mapper;

    static {
        SITE_DOMAIN = "https://shikimori.org";
        API_DOMAIN = SITE_DOMAIN + "/api";
        API_V2_DOMAIN = API_DOMAIN + "/v2";

        JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
        CLIENT = new OkHttpClient();

        clientId = null;
        clientSecret = null;
        appName = null;
        developerName = null;
        accessToken = null;
        redirectUrl = null;

        showResponse = false;

        mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    private Shikimori() {

    }

    private static String buildUrl(String stringUri, RequestVersion requestVersion) {
        String uri = null;
        switch (requestVersion) {
            case API_V1:
                uri = API_DOMAIN + stringUri;
                break;
            case API_V2:
                uri = API_V2_DOMAIN + stringUri;
                break;
            case SITE:
                uri = SITE_DOMAIN + stringUri;
        }
        return uri;
    }

    private static Request.Builder getBuilder(String url, RequestVersion requestVersion) {
        Request.Builder requestBuilder = new Request.Builder()
                .url(buildUrl(url, requestVersion))
                .header("User-Agent", appName + " " + developerName);

        if (accessToken != null) {
            requestBuilder = requestBuilder.header("Authorization", "Bearer " + accessToken);
        }

        return requestBuilder;
    }

    static <T> ApiCall<T> getItem(String url, Class<T> tClass, RequestVersion requestVersion) {
        Request request = getBuilder(url, requestVersion).build();
        return new ApiCall<>(CLIENT.newCall(request), tClass);
    }


    static <T> ApiCall<T> getItem(String url, Class<T> tClass) {
        return getItem(url, tClass, RequestVersion.API_V1);
    }



    static <T> ApiCall<T> postItem(String url, Object arg, Class<T> tReturnClass, RequestVersion requestVersion) {
        try {
            String content = arg instanceof String ? (String) arg : getObjectMapper().writeValueAsString(arg);
            RequestBody requestBody = RequestBody.create(JSON_MEDIA_TYPE, content);
            Request request = getBuilder(url, requestVersion).post(requestBody).build();
            return new ApiCall<>(CLIENT.newCall(request), tReturnClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    static <T> ApiCall<T> postItem(String url, Object arg, Class<T> tReturnClass) {
        return postItem(url, arg, tReturnClass, RequestVersion.API_V1);
    }

    static <T> ApiCall<T> putItem(String url, Object arg, Class<T> tReturnClass, RequestVersion requestVersion) {
        try {
            String content = arg instanceof String ? (String) arg : getObjectMapper().writeValueAsString(arg);
            RequestBody requestBody = RequestBody.create(JSON_MEDIA_TYPE, content);
            Request request = getBuilder(url, requestVersion).put(requestBody).build();
            return new ApiCall<>(CLIENT.newCall(request), tReturnClass);
        } catch (JsonProcessingException e) {
            return null;
        }
    }

    static <T> ApiCall<T> putItem(String url, Object arg, Class<T> tReturnClass) {
        return putItem(url, arg, tReturnClass, RequestVersion.API_V1);
    }

    static <T> ApiCall<T> deleteItem(String url, Class<T> tReturnClass, RequestVersion requestVersion) {
        Request request = getBuilder(url, requestVersion).delete().build();
        return new ApiCall<>(CLIENT.newCall(request), tReturnClass);
    }

    static <T> ApiCall<T> deleteItem(String url, Class<T> tReturnClass) {
        return deleteItem(url, tReturnClass, RequestVersion.API_V1);
    }

    /**
     * Запрашивает новый токен.
     * @param authorizationCode код авторизации.
     * @return новый токен.
     */
    public static ApiCall<OAuthToken> requestAccessToken(String authorizationCode) {
        if (clientId != null && clientSecret != null &&
            authorizationCode != null && redirectUrl != null) {
            ObjectNode objectNode = getObjectMapper().createObjectNode();
            objectNode.put("grant_type", "authorization_code");
            objectNode.put("client_id", clientId);
            objectNode.put("client_secret", clientSecret);
            objectNode.put("code", authorizationCode);
            objectNode.put("redirect_uri", redirectUrl);
            return postItem("/oauth/token", objectNode.toString(), OAuthToken.class, RequestVersion.SITE);
        } else {
            return null;
        }
    }

    /**
     * Обновляет токен.
     * @param refreshToken токен обновления токена.
     * @return обновленный токен.
     */
    public static ApiCall<OAuthToken> refreshToken(String refreshToken) {
        if (clientId != null && clientSecret != null && refreshToken != null) {
            ObjectNode objectNode = getObjectMapper().createObjectNode();
            objectNode.put("grant_type", "refresh_token");
            objectNode.put("client_id", clientId);
            objectNode.put("client_secret", clientSecret);
            objectNode.put("refresh_token", refreshToken);
            return postItem("/oauth/token", objectNode.toString(), OAuthToken.class, RequestVersion.SITE);
        }
        return null;
    }

//    public static ApiCall<SignUpInfo> signUp(String email, String nickname, String password) {
//        if (clientId != null && clientSecret != null && email != null && nickname != null && password != null) {
//            ObjectNode objectNode = getObjectMapper().createObjectNode();
//            ObjectNode userNode = getObjectMapper().createObjectNode();
//            userNode.put("email", email);
//            userNode.put("nickname", nickname);
//            userNode.put("password", password);
//            objectNode.set("user", userNode);
//            return postItem("/oauth/token", objectNode.toString(), SignUpInfo.class, RequestVersion.SITE);
//        }
//        return null;
//    }

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
     * Указывает, показывать ли URL запроса в консоли.
     */
    public static void showRequestUrl(boolean showRequestUrl) {
        Shikimori.showRequestUrl = showRequestUrl;
    }

    /**
     * Инициализирует имя разработчика.
     * @param developerName имя разработчика
     */
    public static void setDeveloperName(String developerName) {
        Shikimori.developerName = developerName;
    }

    public static void setAccessToken(String accessToken) {
        Shikimori.accessToken = accessToken;
    }

    public static void setRedirectUrl(String redirectUrl) {
        Shikimori.redirectUrl = redirectUrl;
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

    static boolean isShowResponse() {
        return showResponse;
    }

    static boolean showRequestUrl() {
        return showRequestUrl;
    }

    enum RequestVersion {
        API_V1,
        API_V2,
        SITE
    }
}
