package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@SuppressWarnings("unused")
public class CommentShort {

	private int id;

	@JsonProperty("commentable_id")
	private int commentableId;

	@JsonProperty("commentable_type")
	private String commentableType;

	private String body;

	@JsonProperty("user_id")
	private int userId;

	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("updated_at")
	private Date updatedAt;

	@JsonProperty("is_summary")
	private boolean isSummary;

	@JsonProperty("is_offtopic")
	private boolean isOfftopic;


	protected CommentShort() {

	}

	public int getId() {
		return id;
	}

	public int getCommentableId() {
		return commentableId;
	}

	public String getCommentableType() {
		return commentableType;
	}

	public String getBody() {
		return body;
	}

	public int getUserId() {
		return userId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public boolean isSummary() {
		return isSummary;
	}

	public boolean isOfftopic() {
		return isOfftopic;
	}
}
