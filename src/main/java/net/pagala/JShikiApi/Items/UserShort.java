package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 *
 * Created by firely-pasha on 7/19/17.
 */

//Type in messages is required!
@SuppressWarnings("unused")
public class UserShort {
    private int id;

    private String nickname;

    protected UserShort() {

    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }
}
