package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ClubConstants {
    @JsonProperty("join_policy")
    private List<String> joinPolicy;

    @JsonProperty("comment_policy")
    private List<String> commentPolicy;

    @JsonProperty("image_upload_policy")
    private List<String> imageUploadPolicy;

    private ClubConstants() {

    }

    public List<String> getJoinPolicy() {
        return joinPolicy;
    }

    public List<String> getCommentPolicy() {
        return commentPolicy;
    }

    public List<String> getImageUploadPolicy() {
        return imageUploadPolicy;
    }
}
