package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Usr.UserStats;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by firely-pasha on 7/20/17.
 */

@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFull extends User {
	private String name;

	private String sex;

	//TODO: Не показано в документации. Не работает здесь, но работает в /users/:id/info.
	@JsonProperty("birth_on")
	private Date birthOn;

	@JsonProperty("full_years")
	private int fullYears;

	@JsonProperty("last_online")
	private String lastOnline;

	private String website;

	private String location;

	private boolean banned;

	private String about;

	@JsonProperty("about_html")
	private String aboutHtml;

	@JsonProperty("common_info")
	private String[] commonInfo;

	@JsonProperty("show_comments")
	private boolean showComments;

	@JsonProperty("in_friends")
	private Boolean inFriends;

	@JsonProperty("is_ignored")
	private boolean isIgnored;

	private UserStats stats;

	@JsonProperty("style_id")
	private int styleId;


	private UserFull() {

	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public Date getBirthOn() {
		return birthOn;
	}

	public int getFullYears() {
		return fullYears;
	}

	public String getLastOnline() {
		return lastOnline;
	}

	public String getWebsite() {
		return website;
	}

	public String getLocation() {
		return location;
	}

	public boolean isBanned() {
		return banned;
	}

	public String getAbout() {
		return about;
	}

	public String getAboutHtml() {
		return aboutHtml;
	}

	public String[] getCommonInfo() {
		return commonInfo;
	}

	public boolean isShowComments() {
		return showComments;
	}

	public Boolean getInFriends() {
		return inFriends;
	}

	public boolean isIgnored() {
		return isIgnored;
	}

	public UserStats getStats() {
		return stats;
	}

	public int getStyleId() {
		return styleId;
	}
}
