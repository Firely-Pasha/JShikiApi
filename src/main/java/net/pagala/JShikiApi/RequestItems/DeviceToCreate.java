package net.pagala.JShikiApi.RequestItems;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceToCreate {
    @JsonProperty("user_id")
    private int userId;

    private String token;

    private String platform;

    private String name;

    public DeviceToCreate(int userId, String token, String platform) {
        this.userId = userId;
        this.token = token;
        this.platform = platform;
    }

    public DeviceToCreate(int userId, String name, String token, String platform) {
        this.userId = userId;
        this.token = token;
        this.platform = platform;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
