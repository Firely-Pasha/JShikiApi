package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 *
 * Created by firely-pasha on 7/19/17.
 */

//Type in messages is required!
@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;

    private String nickname;

    private String avatar;

    private UserImage image;

    @JsonProperty("last_online_at")
    private Date lastOnlineAt;


    protected User() {

    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
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
