package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.TitleStatus;
import net.pagala.JShikiApi.Items.AnimeVideoReport;
import net.pagala.JShikiApi.Usr.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * Created by firely-pasha on 7/19/17.
 */

//Type in messages is required!
@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;

    private String nickname;

    private String avatar;

    private UserImage image;

    @JsonProperty("last_online_at")
    private Calendar lastOnlineAt;


	protected User() {

	}

	public static List<User> getFriends(int id) {
		return Shikimori.getItemList("/users/" + id + "/friends", User[].class);
	}

    public List<User> getFriends() {
        return getFriends(id);
    }

	public static List<Club> getClubs(int id) {
		return Shikimori.getItemList("/users/" + id + "/clubs", Club[].class);
	}

    public List<Club> getClubs() {
        return getClubs(id);
    }

    //TODO: Implement some hidden parameters!
    public static List<AnimeRate> getAnimeRates(int id, TitleStatus status, int limit, int page) {
		String url;
		if (status == null) {
			url = "/users/" + id + "/anime_rates?limit=" + limit + "&page=" + page;
		} else {
			url = "/users/" + id + "/anime_rates?limit=" + limit + "&page=" + page + "&status=" + status.toString();
		}
		return Shikimori.getItemList(url, AnimeRate[].class);
	}

	public List<AnimeRate> getAnimeRates(TitleStatus status, int limit, int page) {
	    return getAnimeRates(id, status, limit, page);
    }


	//TODO: Implement some hidden parameters!
	public static List<MangaRate> getMangaRates(int userId, TitleStatus status, int limit, int page) {
		StringBuilder url = new StringBuilder();
		url.append("users/").append(userId);
		url.append("/manga_rates?");
		url.append("limit=").append(limit);
		url.append("&page=").append(page);

		if (status != null) {
			url.append("&status=").append(status.toString());
		}

		return Shikimori.getItemList(url.toString(), MangaRate[].class);
	}

    public List<MangaRate> getMangaRates(TitleStatus status, int limit, int page) {
	    return getMangaRates(id, status, limit, page);
    }

	public static Favourites getFavourites(int id) {
		return Shikimori.getItem("/users/" + id + "/favourites", Favourites.class);
	}

    public Favourites getFavourites() {
        return getFavourites(id);
    }


    //TODO: Check for authorisation?!
	public static List<Message> getMessages(MessageType messageType, int limit, int page) {
		if (Shikimori.getUserId() != -1) {
			String url = "/users/" + Shikimori.getUserId() + "/messages?type=" + messageType + "&limit=" + limit + "&page=" + page;
			return Shikimori.getItemList(url, Message[].class);
		} else {
			return new ArrayList<>();
		}
	}

	public UnreadMessages getUnreadMessages() {
		return Shikimori.getItem("/users/" + getId() + "/unread_messages", UnreadMessages.class);
	}

    public static List<HistoryItem> getHistory(int id, int limit, int page) {
        String url = "/users/" + id + "/history?&limit=" + limit + "&page=" + page;
        return Shikimori.getItemList(url, HistoryItem[].class);
    }

	public List<HistoryItem> getHistory(int limit, int page) {
        return getHistory(id, limit, page);
	}

	public static List<Ban> getBans(int id) {
		return Shikimori.getItemList("/users/" + id + "/bans", Ban[].class);
	}

    public List<Ban> getBans() {
        return getBans(id);
    }

    public static List<AnimeVideoReport> getAnimeVideoReports(int id, int limit, int page) {
        String url = "/users/" + id + "/anime_video_reports?limit=" + limit + "&page=" + page;
        return Shikimori.getItemList(url, AnimeVideoReport[].class);
    }

    public List<AnimeVideoReport> getAnimeVideoReports(int limit, int page) {
	    return getAnimeVideoReports(id, limit, page);
    }

	public int getId() {
		return id;
	}

	public String getNickname() {
		return nickname;
	}

	public String getAvatar() {
		return avatar;
	}

	public UserImage getImage() {
		return image;
	}

	public Calendar getLastOnlineAt() {
		return lastOnlineAt;
	}
}
