package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("unused")
public class ClubFull extends Club{

	@JsonProperty("comment_policy")
	private String commentPolicy;

	private String description;

	@JsonProperty("description_html")
	private String descriptionHtml;

	private List<Manga> mangas;

	private List<Character> characters;

	@JsonProperty("thread_id")
	private int threadId;

	@JsonProperty("topic_id")
	private int topicId;

	@JsonProperty("user_role")
	private String userRole;

	@JsonProperty("style_id")
	private int styleId;

	//TODO: Mb remove this?
	private List<User> members;

	private List<Anime> animes;

	private List<ClubsImage> images;

	private ClubFull() {

	}

	public String getCommentPolicy() {
		return commentPolicy;
	}

	public String getDescription() {
		return description;
	}

	public String getDescriptionHtml() {
		return descriptionHtml;
	}

	public List<Manga> getMangas() {
		return mangas;
	}

	public List<Character> getCharacters() {
		return characters;
	}

	public int getThreadId() {
		return threadId;
	}

	public int getTopicId() {
		return topicId;
	}

	public String getUserRole() {
		return userRole;
	}

	public int getStyleId() {
		return styleId;
	}

	public List<User> getMembers() {
		return members;
	}

	public List<Anime> getAnimes() {
		return animes;
	}

	public List<ClubsImage> getImages() {
		return images;
	}
}
