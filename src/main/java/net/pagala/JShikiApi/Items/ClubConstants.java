package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClubConstants {
    @JsonProperty("join_policy")
    private String[] joinPolicy;

    @JsonProperty("comment_policy")
    private String[] commentPolicy;

    @JsonProperty("image_upload_policy")
    private String[] imageUploadPolicy;

    private ClubConstants() {

    }

    public String[] getJoinPolicy() {
        return joinPolicy;
    }

    public String[] getCommentPolicy() {
        return commentPolicy;
    }

    public String[] getImageUploadPolicy() {
        return imageUploadPolicy;
    }
}
