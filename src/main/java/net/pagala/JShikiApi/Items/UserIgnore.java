package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class UserIgnore {
    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("is_ignored")
    private boolean isIgnored;

    private UserIgnore() {

    }

    public int getUserId() {
        return userId;
    }

    public boolean isIgnored() {
        return isIgnored;
    }
}
