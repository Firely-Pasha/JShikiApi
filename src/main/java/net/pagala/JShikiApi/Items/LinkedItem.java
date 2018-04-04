package net.pagala.JShikiApi.Items;

import net.pagala.JShikiApi.Items.Image;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@SuppressWarnings("unused")
public class LinkedItem {
    private int id;

    @JsonProperty("topic_url")
    private String topicUrl;

    @JsonProperty("thread_id")
    private int threadId;

    @JsonProperty("topic_id")
    private int topicId;

    protected LinkedItem() {

    }

    public int getId() {
        return id;
    }

    public String getTopicUrl() {
        return topicUrl;
    }

    public int getThreadId() {
        return threadId;
    }

    public int getTopicId() {
        return topicId;
    }
}
