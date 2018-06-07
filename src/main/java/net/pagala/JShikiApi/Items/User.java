package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 *
 * Created by firely-pasha on 7/19/17.
 */

//Type in messages is required!
@SuppressWarnings("unused")
public class User extends UserShort {
    private String avatar;

    private UserImage image;

    @JsonProperty("last_online_at")
    private Date lastOnlineAt;


    protected User() {

    }

    public String getAvatar() {
        return avatar;
    }

    public UserImage getImage() {
        return image;
    }

    public Date getLastOnlineAt() {
        return lastOnlineAt;
    }
}
