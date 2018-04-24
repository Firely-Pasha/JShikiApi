package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.*;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Users {
    public static UserFull get(int id) {
        return getItem("/users/" + id, UserFull.class);
    }

    public static List<User> getList(int limit, int page) {
        return getItemList("/users/?limit=" + limit + "&page=" + page, User[].class);
    }

    public static List<User> search(String searchString, int limit, int page) {
        return getItemList("/users/?search=" + searchString + "&limit=" + limit + "&page=" + page, User[].class);
    }

    /** Возвращает авторизированного пользователя.
     * <p>Если пользователь не авторизирован, то возвращается {@code null}.</p>
     * @return авторизорованный пользователь.
     */
    public static UserInfo whoAmI() {
        return getItem("/users/whoami", UserInfo.class);
    }

    public static List<User> getFriends(int id) {
        return getItemList("/users/" + id + "/friends", User[].class);
    }

    public static UserInfo getUserInfo(int id) {
        return getItem("/users/" + id +"/info", UserInfo.class);
    }

    public static List<Club> getClubs(int id) {
        return getItemList("/users/" + id + "/clubs", Club[].class);
    }

    /**
     * Метод для получения списка аниме пользователя с заданным статусом.
     * <p>Выдает {@link Shikimori#responseCode} = 403 при закрытом списке.</p>
     * @param userId идентифиакатор пользователя
     * @param status статус просмотра аниме
     * @param limit количество выдаваемых результатов
     * @param page номер страницы выдаваемых результатов
     * @return список аниме пользователя с заданным статусом ({@code status})
     */
    public static List<AnimeRate> getAnimeRates(int userId, TitleListStatus status, int limit, int page) {
        StringBuilder url = new StringBuilder();
        url.append("/users/").append(userId);
        url.append("/anime_rates?");
        url.append("limit=").append(limit);
        url.append("&page=").append(page);
        if (status != null) {
            url.append("&status=").append(status.toString());
        }
        return getItemList(url.toString(), AnimeRate[].class);
    }

    /**
     * Метод {@link Users#getAnimeRates(int userId, TitleListStatus status, int limit, int page)}
     * при {@code status} = null.
     */
    public static List<AnimeRate> getAnimeRates(int userId, int limit, int page) {
        return getAnimeRates(userId, null, limit, page);
    }

    /**
     * Метод для получения списка манги пользователя с заданным статусом.
     * <p>
     * Выдает {@link Shikimori#responseCode} = 403 при закрытом списке.
     * @param userId идентифиакатор пользователя
     * @param status статус чтения манги
     * @param limit количество выдаваемых результатов
     * @param page номер страницы выдаваемых результатов
     * @return список манги пользователя с заданным статусом ({@code status})
     */
    public static List<MangaRate> getMangaRates(int userId, TitleListStatus status, int limit, int page) {
        StringBuilder url = new StringBuilder();
        url.append("/users/").append(userId);
        url.append("/manga_rates?");
        url.append("limit=").append(limit);
        url.append("&page=").append(page);
        if (status != null) {
            url.append("&status=").append(status.toString());
        }
        return getItemList(url.toString(), MangaRate[].class);
    }

    /**
     * Метод {@link Users#getMangaRates(int userId, TitleListStatus status, int limit, int page)}
     * при {@code status} = null.
     */
    public static List<MangaRate> getMangaRates(int userId, int limit, int page) {
        return getMangaRates(userId, null, limit, page);
    }

    public static Favourites getFavourites(int id) {
        return getItem("/users/" + id + "/favourites", Favourites.class);
    }

    public static List<MessageFull> getMessages(MessageType messageType, int currentUserId, int limit, int page) {
        String url = "/users/" + currentUserId + "/messages?type=" + messageType + "&limit=" + limit + "&page=" + page;
        return getItemList(url, MessageFull[].class);
    }

    public UnreadMessages getUnreadMessages(int currentUserId) {
        return getItem("/users/" + currentUserId + "/unread_messages", UnreadMessages.class);
    }

    public static List<HistoryItem> getHistory(int id, int limit, int page) {
        String url = "/users/" + id + "/history?&limit=" + limit + "&page=" + page;
        return getItemList(url, HistoryItem[].class);
    }

    public static List<Ban> getBans(int id) {
        return getItemList("/users/" + id + "/bans", Ban[].class);
    }

    public static List<AnimeVideoReport> getAnimeVideoReports(int id, int limit, int page) {
        String url = "/users/" + id + "/anime_video_reports?limit=" + limit + "&page=" + page;
        return getItemList(url, AnimeVideoReport[].class);
    }
}
