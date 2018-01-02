package net.pagala.JShikiApi.Items;

import net.pagala.JShikiApi.Items.Image;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@SuppressWarnings("unused")
public class LinkedTitle {
	private int id;

	@JsonProperty("topic_url")
	private String topicUrl;

	@JsonProperty("thread_id")
	private String threadId;

	@JsonProperty("topic_id")
	private String topicId;

	private String type;

	private String name;


	private String russian;

	private Image image;

	private String url;

	private String kind;

	private String status;

	private int episodes;

	@JsonProperty("episodes_aired")
	private int episodesAired;

	@JsonProperty("aired_on")
	private Date airedOn;

	@JsonProperty("released_on")
	private Date releasedOn;

	private LinkedTitle() {

	}

	public int getId() {
		return id;
	}

	public String getTopicUrl() {
		return topicUrl;
	}

	public String getThreadId() {
		return threadId;
	}

	public String getTopicId() {
		return topicId;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getRussian() {
		return russian;
	}

	public Image getImage() {
		return image;
	}

	public String getUrl() {
		return url;
	}

	public String getKind() {
		return kind;
	}

	public String getStatus() {
		return status;
	}

	public int getEpisodes() {
		return episodes;
	}

	public int getEpisodesAired() {
		return episodesAired;
	}

	public Date getAiredOn() {
		return airedOn;
	}

	public Date getReleasedOn() {
		return releasedOn;
	}
}
