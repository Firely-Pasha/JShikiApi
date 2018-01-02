package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.pagala.JShikiApi.Filters.CommentFilter.CommentFilter;
import net.pagala.JShikiApi.Items.Comment;
import net.pagala.JShikiApi.RequestItems.CommentToCreate;

import java.io.IOException;
import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class Comments {

    private Comments() {

    }

    public static Comment get(int commentId) {
        return Shikimori.getItem("/comments/" + commentId, Comment.class);
    }


    public static List<Comment> getList(CommentFilter filter) {
        return Shikimori.getItemList("/comments?" + filter.build(), Comment[].class);
    }

    //TODO: What's frontend?
    //FIXME: Returns something wrong.
    public static int create(CommentToCreate comment) {
        ObjectNode rootNode = mapper.createObjectNode();

        rootNode.put("broadcast", false);

        try {
            String jsonComment = mapper.writeValueAsString(comment);
            JsonNode node = mapper.readTree(jsonComment);
            rootNode.set("comment", node);

            rootNode.put("frontend", true);
            System.out.println(rootNode.toString());

            String data = mapper.writeValueAsString(rootNode);
            JsonNode node1 = postRequest("/comments", data, true);
            return node1.get("id").asInt();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public static Comment update(int commentId, String commentBody) {
        ObjectNode rootNode = mapper.createObjectNode();

        ObjectNode comment = mapper.createObjectNode();
        comment.put("body", commentBody);

        rootNode.set("comment", comment);
        rootNode.put("frontend", false);

        System.out.println(rootNode.toString());

        JsonNode node = putRequest("/comments/" + commentId, rootNode.toString(), true);
        try {
            return mapper.readValue(node.toString(), Comment.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String delete(int commentId) {
        return deleteRequest("/comments/" + commentId, true).get("notice").asText();
    }
}