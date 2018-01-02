package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.pagala.JShikiApi.RequestItems.MessageToSend;
import net.pagala.JShikiApi.Items.Message;
import net.pagala.JShikiApi.Items.MessageType;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class Messages {

    private Messages() {

    }

    public static Message get(int messageId) {
        return getItem("/messages/" + messageId, Message.class);
    }

    public static JsonNode send(MessageToSend message) {
        System.out.println(message.build());
        switchApiVersion(Shikimori.ApiVersion.V1);
        JsonNode node = postRequest("/messages", message.build(), true);
        switchApiVersion(Shikimori.ApiVersion.V2);
        return node;
    }

    public static JsonNode update(int messageId, String body) {
        ObjectNode rootNode = mapper.createObjectNode();

        ObjectNode messageNode = mapper.createObjectNode();
        messageNode.put("body", body);

        rootNode.put("frontend", true);
        rootNode.set("message", messageNode);

        return putRequest("/messages/" + messageId, rootNode.toString(), true);
    }

    public static void delete(int messageId) {
        deleteRequest("/messages/" + messageId, false);
    }

    public static void markRead(boolean read, int... messageIds) {
        ObjectNode rootNode = mapper.createObjectNode();

        if (messageIds.length != 0) {
            StringBuilder sb = new StringBuilder();

            sb.append(messageIds[0]);

            for (int i = 1; i < messageIds.length; i++) {
                sb.append(",").append(messageIds[i]);
            }

            rootNode.put("ids", sb.toString());
        }

        rootNode.put("is_read", read ? "1" : "0");
        postRequest("/messages/mark_read", rootNode.toString(), false);
    }

    public static void readAll(MessageType type) {
        ObjectNode rootNode = mapper.createObjectNode();

        rootNode.put("frontend", false);

        if (type != null) {
            rootNode.put("type", type.toString());
        }

        postRequest("/messages/read_all", rootNode.toString(), false);
    }

    public static void deleteAll(MessageType type) {
        ObjectNode rootNode = mapper.createObjectNode();

        rootNode.put("frontend", false);

        if (type != null) {
            rootNode.put("type", type.toString());
        }

        postRequest("/messages/delete_all", rootNode.toString(), false);
    }
}