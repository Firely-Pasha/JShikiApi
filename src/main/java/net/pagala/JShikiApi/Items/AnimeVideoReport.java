package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AnimeVideoReport {
    private int id;

    private String kind;

    private String state;

    private String message;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("anime_video")
    private AnimeVideo animeVideo;

    private User user;

    private User approver;

    private AnimeVideoReport() {

    }

    public int getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public AnimeVideo getAnimeVideo() {
        return animeVideo;
    }

    public User getUser() {
        return user;
    }

    public User getApprover() {
        return approver;
    }
}
