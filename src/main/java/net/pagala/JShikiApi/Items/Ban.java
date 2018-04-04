package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@SuppressWarnings("unused")
public class Ban {
    private int id;

    @JsonProperty("user_id")
    private int userId;

    private CommentShort comment;

    @JsonProperty("moderator_id")
    private int moderatorId;

    private String reason;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("duration_minutes")
    private int durationMinutes;

    private User user;

    private User moderator;


    private Ban() {

    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public CommentShort getComment() {
        return comment;
    }

    public int getModeratorId() {
        return moderatorId;
    }

    public String getReason() {
        return reason;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public User getUser() {
        return user;
    }

    public User getModerator() {
        return moderator;
    }
}
