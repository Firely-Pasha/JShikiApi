package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.*;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Users {
    public static ApiCall<UserFull> get(int id) {
        return getItem("/users/" + id, UserFull.class);
    }

    public static ApiCall<User[]> getList(int limit, int page) {
        return getItem("/users/?limit=" + limit + "&page=" + page, User[].class);
    }

    public static ApiCall<User[]> search(String searchString, int limit, int page) {
        return getItem("/users/?search=" + searchString + "&limit=" + limit + "&page=" + page, User[].class);
    }

    /** Возвращает авторизированного пользователя.
     * @return авторизорованный пользователь.
     */
    public static ApiCall<UserInfo> whoAmI() {
        return getItem("/users/whoami", UserInfo.class);
    }

    public static ApiCall<User[]> getFriends(int id) {
        return getItem("/users/" + id + "/friends", User[].class);
    }

    public static ApiCall<UserInfo> getUserInfo(int id) {
        return getItem("/users/" + id +"/info", UserInfo.class);
    }

    public static ApiCall<Club[]> getClubs(int id) {
        return getItem("/users/" + id + "/clubs", Club[].class);
    }

    /**
     * Метод для получения списка аниме пользователя с заданным статусом.
     * Выдает {@link ApiResponse#code()} = 403 при закрытом списке.
     * @param userId идентифиакатор пользователя
     * @param status статус просмотра аниме
     * @param limit количество выдаваемых результатов
     * @param page номер страницы выдаваемых результатов
     * @return список аниме пользователя с заданным статусом ({@code status})
     */
    public static ApiCall<AnimeRate[]> getAnimeRates(int userId, TitleListStatus status, int limit, int page) {
        StringBuilder url = new StringBuilder();
        url.append("/users/").append(userId);
        url.append("/anime_rates?");
        url.append("limit=").append(limit);
        url.append("&page=").append(page);
        if (status != null) {
            url.append("&status=").append(status.toString());
        }
        return getItem(url.toString(), AnimeRate[].class);
    }

    /**
     * Метод {@link Users#getAnimeRates(int userId, TitleListStatus status, int limit, int page)}
     * при {@code status} = null.
     */
    public static ApiCall<AnimeRate[]> getAnimeRates(int userId, int limit, int page) {
        return getAnimeRates(userId, null, limit, page);
    }

    /**
     * Метод для получения списка манги пользователя с заданным статусом.
     * <p>
     * Выдает {@link ApiResponse#code()} = 403 при закрытом списке.
     * @param userId идентифиакатор пользователя
     * @param status статус чтения манги
     * @param limit количество выдаваемых результатов
     * @param page номер страницы выдаваемых результатов
     * @return список манги пользователя с заданным статусом ({@code status})
     */
    public static ApiCall<MangaRate[]> getMangaRates(int userId, TitleListStatus status, int limit, int page) {
        StringBuilder url = new StringBuilder();
        url.append("/users/").append(userId);
        url.append("/manga_rates?");
        url.append("limit=").append(limit);
        url.append("&page=").append(page);
        if (status != null) {
            url.append("&status=").append(status.toString());
        }
        return getItem(url.toString(), MangaRate[].class);
    }

    public static ApiCall<MangaRate[]> getMangaRates(int userId, int limit, int page) {
        return getMangaRates(userId, null, limit, page);
    }

    public static ApiCall<Favourites> getFavourites(int id) {
        return getItem("/users/" + id + "/favourites", Favourites.class);
    }

    public static ApiCall<MessageFull[]> getMessages(MessageType messageType, int currentUserId, int limit, int page) {
        String url = "/users/" + currentUserId + "/messages?type=" + messageType + "&limit=" + limit + "&page=" + page;
        return getItem(url, MessageFull[].class);
    }

    public ApiCall<UnreadMessages> getUnreadMessages(int currentUserId) {
        return getItem("/users/" + currentUserId + "/unread_messages", UnreadMessages.class);
    }

    public static ApiCall<HistoryItem[]> getHistory(int id, int limit, int page) {
        String url = "/users/" + id + "/history?&limit=" + limit + "&page=" + page;
        return getItem(url, HistoryItem[].class);
    }

    public static ApiCall<Ban[]> getBans(int id) {
        return getItem("/users/" + id + "/bans", Ban[].class);
    }

    public static ApiCall<AnimeVideoReport[]> getAnimeVideoReports(int id, int limit, int page) {
        String url = "/users/" + id + "/anime_video_reports?limit=" + limit + "&page=" + page;
        return getItem(url, AnimeVideoReport[].class);
    }
}
