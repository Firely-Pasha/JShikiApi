package net.pagala.JShikiApi.Items;

import net.pagala.JShikiApi.Core.Shikimori;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Date;

public class Topic {
    private int id;

    @JsonProperty("topic_title")
    private String topicTitle;

    private String body;

    @JsonProperty("html_body")
    private String htmlBody;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("comments_count")
    private String commentsCount;

    private Forum forum;

    private User user;

    private String type;

    @JsonProperty("linked_id")
    private int linkedId;

    @JsonProperty("linked_type")
    private LinkedType linkedType;

    //TODO: Solve problem with different types of objects.
    @JsonProperty("linked")
    private JsonNode linked;

    private boolean viewed;

    @JsonProperty("last_comment_viewed")
    private boolean lastCommentViewed;


    private Topic() {

    }

    public int getId() {
        return id;
    }

    public String getTopicTitle() {
        return topicTitle;
    }

    public String getBody() {
        return body;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCommentsCount() {
        return commentsCount;
    }

    public Forum getForum() {
        return forum;
    }

    public User getUser() {
        return user;
    }

    public String getType() {
        return type;
    }

    public int getLinkedId() {
        return linkedId;
    }

    public LinkedType getLinkedType() {
        return linkedType;
    }

    public <T> T getLinked(Class<T> clazz) {
        if (linked.toString().equals("null")) {
            return null;
        }

        try {
            return Shikimori.getObjectMapper().treeToValue(linked, clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean isLinked() {
        return !linked.toString().equals("null");
    }

    public JsonNode getLinked() {
        return linked;
    }

    public boolean isViewed() {
        return viewed;
    }

    public boolean isLastCommentViewed() {
        return lastCommentViewed;
    }
}
