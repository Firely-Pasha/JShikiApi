package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Achievement {

    private int id;

    @JsonProperty("neko_id")
    private String nekoId;

    private int level;

    private int progress;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    private Achievement() {

    }

    public int getId() {
        return id;
    }

    public String getNekoId() {
        return nekoId;
    }

    public int getLevel() {
        return level;
    }

    public int getProgress() {
        return progress;
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
}
