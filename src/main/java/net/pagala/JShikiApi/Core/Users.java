package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.*;

import java.util.ArrayList;
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

    //TODO: Data consistency broken again. Wait for fix.
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

    //TODO: Implement some hidden parameters!
    public static List<AnimeRate> getAnimeRates(int userId, TitleListStatus status, int limit, int page) {
        String url;
        if (status == null) {
            url = "/users/" + userId + "/anime_rates?limit=" + limit + "&page=" + page;
        } else {
            url = "/users/" + userId + "/anime_rates?limit=" + limit + "&page=" + page + "&status=" + status.toString();
        }
        return getItemList(url, AnimeRate[].class);
    }

    //TODO: Implement some hidden parameters!
    public static List<MangaRate> getMangaRates(int userId, TitleListStatus status, int limit, int page) {
        StringBuilder url = new StringBuilder();
        url.append("users/").append(userId);
        url.append("/manga_rates?");
        url.append("limit=").append(limit);
        url.append("&page=").append(page);

        if (status != null) {
            url.append("&status=").append(status.toString());
        }

        return getItemList(url.toString(), MangaRate[].class);
    }

    public static Favourites getFavourites(int id) {
        return getItem("/users/" + id + "/favourites", Favourites.class);
    }

    //TODO: Check for authorisation?!
    public static List<Message> getMessages(MessageType messageType, int limit, int page) {
        if (Shikimori.getUserId() != -1) {
            String url = "/users/" + Shikimori.getUserId() + "/messages?type=" + messageType + "&limit=" + limit + "&page=" + page;
            return getItemList(url, Message[].class);
        } else {
            return new ArrayList<>();
        }
    }

    public UnreadMessages getUnreadMessages() {
        if (Shikimori.getUserId() == -1) {
            return null;
        }

        return getItem("/users/" + Shikimori.getUserId() + "/unread_messages", UnreadMessages.class);
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
