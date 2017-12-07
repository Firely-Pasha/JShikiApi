package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.pagala.JShikiApi.Usr.UserImage;

import java.util.Date;

public class UserInfo {

    private int id;

    private String nickname;

    private String avatar;

    private UserImage image;

    @JsonProperty("last_online_at")
    private Date lastOnlineAt;

    private String name;

    private String sex;

    private String website;

    @JsonProperty("birth_on")
    private Date birthOn;

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

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getWebsite() {
        return website;
    }

    public Date getBirthOn() {
        return birthOn;
    }
}
