package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dialog {
    @JsonProperty("target_user")
    private User targetUser;

    private Message message;

    private Dialog() {

    }

    public User getTargetUser() {
        return targetUser;
    }

    public Message getMessage() {
        return message;
    }
}
