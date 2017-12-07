package net.pagala.JShikiApi.Items;

import net.pagala.JShikiApi.Core.User;
import net.pagala.JShikiApi.Usr.ShortMessage;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Dialog {
    @JsonProperty("target_user")
    private User targetUser;

    private ShortMessage message;

    private Dialog() {

    }

    public User getTargetUser() {
        return targetUser;
    }

    public ShortMessage getMessage() {
        return message;
    }
}
