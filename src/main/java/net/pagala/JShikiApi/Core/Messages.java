package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.pagala.JShikiApi.Items.Message;
import net.pagala.JShikiApi.Items.MessageFull;
import net.pagala.JShikiApi.Items.MessageType;
import net.pagala.JShikiApi.RequestItems.MessageToCreate;

import java.util.Arrays;
import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class Messages {

    private Messages() {

    }

    public static ApiCall<MessageFull> get(int messageId) {
        return getItem("/messages/" + messageId, MessageFull.class);
    }

    public static ApiCall<Message> create(MessageToCreate message) {
        return postItem("/messages", message, Message.class);
    }

    // TODO: Make model for this item.
    public static ApiCall<Message> update(int messageId, String body) {
        return putItem("/messages/" + messageId, new MessageToUpdate(body), Message.class);
    }

    public static ApiCall delete(int messageId) {
        return deleteItem("/messages/" + messageId, null);
    }

    public static ApiCall markRead(boolean read, Integer... messageIds) {
        return markRead(read, Arrays.asList(messageIds));
    }
    public static ApiCall markRead(boolean read, List<Integer> messageIds) {
        return postItem("/messages/mark_read", new MarkAsRead(read, messageIds), null);
    }

    public static ApiCall readAll(MessageType type) {
        return postItem("/messages/read_all", new AllAction(type), null);
    }

    public static ApiCall deleteAll(MessageType type) {
        return postItem("/messages/delete_all", new AllAction(type), null);
    }

    private static class MessageToUpdate {
        private boolean frontend;
        private final Message message;

        private MessageToUpdate(String body) {
            this.frontend = false;
            this.message = new Message(body);
        }

        private class Message {
            private String body;

            public Message(String body) {
                this.body = body;
            }

            public String getBody() {
                return body;
            }
        }

        public boolean isFrontend() {
            return frontend;
        }

        public Message getMessage() {
            return message;
        }
    }

    private static class MarkAsRead {
        @JsonProperty("ids")
        private final String ids;
        @JsonProperty("is_read")
        private final String isRead;

        private MarkAsRead(boolean isRead, List<Integer> ids) {
            this.isRead = isRead ? "1" : "0";
            if (ids.isEmpty()) {
                this.ids = "";
                return;
            }
            StringBuilder sb = new StringBuilder(ids.get(0).toString());
            for (int i = 1; i < ids.size(); i++) {
                sb.append(',').append(ids.get(i));
            }
            this.ids = sb.toString();
        }

        public String getIds() {
            return ids;
        }

        public String isRead() {
            return isRead;
        }
    }

    private static class AllAction {
        private final boolean frontend;
        private final String type;

        private AllAction(MessageType type) {
            this.frontend = false;
            this.type = type.toString();
        }

        public boolean isFrontend() {
            return frontend;
        }

        public String getType() {
            return type;
        }
    }
}