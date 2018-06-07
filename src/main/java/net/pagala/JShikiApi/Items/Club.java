package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class Club {

    private int id;

    private String name;

    private ClubLogo logo;

    @JsonProperty("is_censored")
    private boolean isCensored;

    @JsonProperty("join_policy")
    private String joinPolicy;

    @JsonProperty("comment_policy")
    private String commentPolicy;


    protected Club() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ClubLogo getLogo() {
        return logo;
    }

    public boolean isCensored() {
        return isCensored;
    }

    public String getJoinPolicy() {
        return joinPolicy;
    }

    public String getCommentPolicy() {
        return commentPolicy;
    }
}
