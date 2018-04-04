package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.pagala.JShikiApi.Core.Shikimori;

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
    private JsonNode linked;

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

    public LinkedAnime getLinkedAnime() {
        try {
            return Shikimori.getObjectMapper().treeToValue(linked, LinkedAnime.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public LinkedItem getLinkedItem() {
        try {
            return Shikimori.getObjectMapper().treeToValue(linked, LinkedItem.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
