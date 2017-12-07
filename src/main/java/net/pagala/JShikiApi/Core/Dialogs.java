package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.databind.JsonNode;
import net.pagala.JShikiApi.Items.Dialog;
import net.pagala.JShikiApi.Usr.Message;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.deleteRequest;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public class Dialogs {
    private Dialogs() {

    }

    public static List<Dialog> list() {
        return getItemList("/dialogs", Dialog[].class);
    }

    public static List<Message> getDialigWith(int userId) {
        return getItemList("/dialogs/" + userId, Message[].class);
    }

//        public static List<Message> get(String nickname) {
//            return getItemList("/dialogs/" + nickname, Message[].class);
//        }

    public static JsonNode delete(int userId) {
        return deleteRequest("/dialogs/" + userId, true);
    }
}
