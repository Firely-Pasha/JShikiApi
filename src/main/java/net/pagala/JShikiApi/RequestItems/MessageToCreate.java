package net.pagala.JShikiApi.RequestItems;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.pagala.JShikiApi.Core.Shikimori;
import net.pagala.JShikiApi.Items.MessageKind;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class MessageToCreate {
    private String body;

    @JsonProperty("from_id")
    private int fromId;

    private MessageKind kind;

    @JsonProperty("to_id")
    private int toId;

    public MessageToCreate(String body, MessageKind kind, int fromId, int toId) {
        this.body = body;
        this.kind = kind;
        this.fromId = fromId;
        this.toId = toId;
    }

    public String build() {
        ObjectMapper mapper = Shikimori.getObjectMapper();
        ObjectNode rootNode = mapper.createObjectNode();

        try {
            String message = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
            JsonNode jsonMessage = mapper.readTree(message);
            rootNode.put("frontend", true);
            rootNode.set("message", jsonMessage);
            return rootNode.toString();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public MessageKind getKind() {
        return kind;
    }

    public void setKind(MessageKind kind) {
        this.kind = kind;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }
}