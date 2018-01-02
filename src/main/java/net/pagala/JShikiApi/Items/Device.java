package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Device {

    private int id;

    @JsonProperty("user_id")
    private int userId;

    private String token;

    private String platform;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    private String name;

    private Device() {

    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public String getPlatform() {
        return platform;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getName() {
        return name;
    }
}
