package net.pagala.JShikiApi.RequestItems;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.pagala.JShikiApi.Items.MessageKind;

public class MessageToCreate {
    private boolean frontEnd;
    private final Message message;

    public MessageToCreate(String body, MessageKind kind, int fromId, int toId) {
        this.frontEnd = false;
        this.message = new Message(body, kind, fromId, toId);
    }

    public final class Message {
        private String body;

        @JsonProperty("from_id")
        private int fromId;

        private MessageKind kind;

        @JsonProperty("to_id")
        private int toId;

        private Message(String body, MessageKind kind, int fromId, int toId) {
            this.body = body;
            this.fromId = fromId;
            this.kind = kind;
            this.toId = toId;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public int getFromId() {
            return fromId;
        }

        public void setFromId(int fromId) {
            this.fromId = fromId;
        }

        public MessageKind getKind() {
            return kind;
        }

        public void setKind(MessageKind kind) {
            this.kind = kind;
        }

        public int getToId() {
            return toId;
        }

        public void setToId(int toId) {
            this.toId = toId;
        }
    }

    public boolean isFrontEnd() {
        return frontEnd;
    }

    public void setFrontEnd(boolean frontEnd) {
        this.frontEnd = frontEnd;
    }

    public Message getMessage() {
        return message;
    }
}