package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class TopicIgnore {
    @JsonProperty("topic_id")
    private int topicId;

    @JsonProperty("is_ignored")
    private boolean isIgnored;

    private TopicIgnore() {

    }

    public int getTopicId() {
        return topicId;
    }

    public boolean isIgnored() {
        return isIgnored;
    }
}
