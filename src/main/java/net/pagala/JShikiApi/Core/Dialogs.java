package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.databind.JsonNode;
import net.pagala.JShikiApi.Items.Dialog;
import net.pagala.JShikiApi.Items.MessageFull;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.deleteRequest;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Dialogs {

    private Dialogs() {

    }

    public static List<MessageFull> get(int userId) {
        return getItemList("/dialogs/" + userId, MessageFull[].class);
    }

    public static List<MessageFull> get(String nickname) {
        return getItemList("/dialogs/" + nickname, MessageFull[].class);
    }

    public static List<Dialog> getList() {
        return getItemList("/dialogs", Dialog[].class);
    }

    public static JsonNode delete(int userId) {
        return deleteRequest("/dialogs/" + userId, true);
    }
}
