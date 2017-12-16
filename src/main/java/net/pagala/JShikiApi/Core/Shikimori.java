package net.pagala.JShikiApi.Core;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.concurrent.*;

import net.pagala.JShikiApi.Filters.SearchFilter.MangaSearchFilter;
import net.pagala.JShikiApi.Items.*;
import net.pagala.JShikiApi.Items.Character;
import net.pagala.JShikiApi.Filters.SearchFilter.AnimeSearchFilter;
import net.pagala.JShikiApi.Usr.Ban;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * Created by firely-pasha on 7/11/17.
 */

@SuppressWarnings({"unused", "Duplicates", "MismatchedQueryAndUpdateOfCollection"})
public class Shikimori {
    public static final String SITE_DOMAIN;

    public static final String API_DOMAIN;

    private static ApiVersion apiVersion;

    private static String nickname;

    private static String accessToken;

    private static String appName;

    static ObjectMapper mapper;

    private static HttpClient client;

    private static int userId;

    static {
        SITE_DOMAIN = "https://shikimori.org";
        API_DOMAIN  = SITE_DOMAIN + "/api";
        mapper = new ObjectMapper();
        client = HttpClients.createDefault();
        userId = -1;
        appName = null;
        accessToken = null;
        apiVersion = ApiVersion.V1;
    }


    private Shikimori() {

    }

    private static JsonNode getRequest(String stringUrl) {
        HttpGet httpGet = null;
        try {
            httpGet = new HttpGet(buildUri(stringUrl));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request(httpGet, true);
    }

    static JsonNode postRequest(String stringUrl, String arg, boolean readResponse) {
        HttpPost httpPost = null;
        try {
            httpPost = new HttpPost(buildUri(stringUrl));
            httpPost.setEntity(new StringEntity(arg));
            httpPost.addHeader("Content-Type", "application/json");
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return request(httpPost, readResponse);
    }

    //TODO: Make return notice for some methods.
    static JsonNode deleteRequest(String stringUrl, boolean readResponse) {
        HttpDelete httpDelete = null;
        try {
            httpDelete = new HttpDelete(buildUri(stringUrl));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return request(httpDelete, readResponse);
    }

    static JsonNode putRequest(String stringUrl, String arg, boolean readResponse) {
        HttpPut httpPut = null;
        try {
            httpPut = new HttpPut(buildUri(stringUrl));
            httpPut.setEntity(new StringEntity(arg));
            httpPut.addHeader("Content-Type", "application/json");
        } catch (URISyntaxException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return request(httpPut, readResponse);
    }


    private static JsonNode request(final HttpUriRequest request, final boolean readResponse) {
        request.setHeader("User-Agent", "JShikiApi Firely-Pasha");

        if (accessToken != null) {
            request.addHeader("X-User-Nickname", nickname);
            request.addHeader("X-User-Api-Access-Token", accessToken);
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

            System.out.println(jsonResponse[0].toString());

            return response;
        });

        while (!result.isDone());
        executor.shutdown();

        return jsonResponse[0];
    }

    private static URI buildUri(String stringUri) throws URISyntaxException {
        URI uri = null;

        switch (apiVersion) {
            case V1:
                uri = new URI(API_DOMAIN + stringUri);
                break;
            case V2:
                uri = new URI(API_DOMAIN + "/v2" + stringUri);
                break;
        }

        return uri;
    }

    static void switchApiVersion(ApiVersion apiVersion) {
        Shikimori.apiVersion = apiVersion;
    }

    public static boolean logIn(String nickname, String password) {
        Shikimori.nickname = nickname;
        String stringUrl = "/access_token?nickname=" + nickname + "&password=" + password;
        JsonNode rootNode = getRequest(stringUrl);
        String accessToken = rootNode.get("api_access_token").asText();
        boolean isSuccessful = !accessToken.equals("null");

        if (isSuccessful) {
            Shikimori.accessToken = accessToken;
            userId = Shikimori.whoAmI().getId();
            return true;
        }

        Shikimori.nickname = null;
        return false;
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

    static <T> List<T> getItemList(String url, Class<T[]> tClass) {
        T[] items = getItem(url, tClass);
        if (items == null) {
            return  new ArrayList<>();
        }
        return new ArrayList<>(Arrays.asList(items));
    }

    public static AnimeFull getAnime(int id) {
        return getItem("/animes/" + id, AnimeFull.class);
    }

    public static MangaFull getManga(int id) {
        return getItem("/mangas/" + id, MangaFull.class);
    }

    public static MangaFull getRanobe(int id) {
        return getItem("/ranobe/" + id, MangaFull.class);
    }

    public static CharacterFull getCharacter(int id) {
        return getItem("/characters/" + id, CharacterFull.class);
    }

    public static CharacterFull getHuman(int id) {
        return getItem("/people/" + id, CharacterFull.class);
    }

    public static UserFull getUser(int id) {
        return getItem("/users/" + id, UserFull.class);
    }

    public static List<User> getUsers(int limit, int page) {
        return getItemList("/users/?limit=" + limit + "&page=" + page, User[].class);
    }

    //TODO: Make another class for whoAmI.
    public static UserFull whoAmI() {
        return getItem("/users/whoami", UserFull.class);
    }

    public static ClubFull getClub(int id) {
        return Shikimori.getItem("/clubs/" + id, ClubFull.class);
    }

    public static List<CalendarItem> getCalendar() {
        return getItemList("/calendar/", CalendarItem[].class);
    }

    public static List<Anime> getAnimes(AnimeSearchFilter animeSearchFilter) {
        return getItemList("/animes" + animeSearchFilter.buildQuery(), Anime[].class);
    }

    public static List<Manga> getMangas(MangaSearchFilter mangaSearchFilter) {
        return getItemList("/mangas" + mangaSearchFilter.buildQuery(), Manga[].class);
    }

    public static List<Character> getCharacters(String searchString) {
        return getItemList("/characters/search?search=" + searchString, Character[].class);
    }

    public static List<Character> getPeople(String searchString) {
        return getItemList("/people/search?search=" + searchString, Character[].class);
    }

    public static List<Genre> getGenres() {
        return getItemList("/genres", Genre[].class);
    }

    public static List<Ban> getBans(int limit, int page) {
        return getItemList("/bans?&limit=" + limit + "&page=" + page, Ban[].class);
    }

    public static List<Club> getClubs(int limit, int page) {
        return getItemList("/clubs?limit=" + limit + "&page=" + page, Club[].class);
    }

    public static List<Club> getClubs(int limit, int page, String searchString) {
        String url = "/clubs?limit=" + limit + "&page=" + page + "&search=" + searchString;
        return getItemList(url, Club[].class);
    }

    public static Topic getTopic(int id) {
        return getItem("/topics/" + id, Topic.class);
    }

    // limit <= 30
    public static List<Topic> getTopics(Forums forum, int limit, int page) {
        String url = "/topics?forum=" + forum + "&limit=" + limit + "&page=" + page;
        return getItemList(url, Topic[].class);
    }

    public static List<Studio> getStudios() {
        return getItemList("/studios", Studio[].class);
    }

    public static List<Publisher> getPublishers() {
        return getItemList("/publishers", Publisher[].class);

    }

    public static List<Forum> getForums() {
        return getItemList("/forums", Forum[].class);
    }

    public static String getNickname() {
        return nickname;
    }

    public static void setAppName(String appName) {
        Shikimori.appName = appName;
    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }

    public static int getUserId() {
        return userId;
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

    enum ApiVersion {
        V1,
        V2,
    }
}