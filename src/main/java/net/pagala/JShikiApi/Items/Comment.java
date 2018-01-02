package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment extends CommentShort {
    @JsonProperty("html_body")
    private String htmlBody;

    private String html;

    @JsonProperty("can_be_edited")
    private boolean canBeEdited;

    private User user;

    private Comment() {

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
