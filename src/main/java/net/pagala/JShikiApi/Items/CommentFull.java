package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentFull extends Comment {
    @JsonProperty("html_body")
    private String htmlBody;

    private String html;

    @JsonProperty("can_be_edited")
    private boolean canBeEdited;

    private User user;

    private CommentFull() {

    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public String getHtml() {
        return html;
    }

    public boolean isCanBeEdited() {
        return canBeEdited;
    }

    public User getUser() {
        return user;
    }
}
