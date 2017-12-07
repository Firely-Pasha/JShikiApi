package net.pagala.JShikiApi.Usr;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ShortMessage {
    private int id;

    private String kind;

    private boolean read;

    private String body;

    @JsonProperty("html_body")
    private String htmlBody;

    @JsonProperty("created_at")
    private Date createdAt;

    //TODO: Maybe replace with JsonNode and make individual method for each type of title?
    @JsonProperty("linked")
    private LinkedTitle linked;

    protected ShortMessage() {

    }


    public int getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
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

    public LinkedTitle getLinkedTitle() {
        return linked;
    }
}
