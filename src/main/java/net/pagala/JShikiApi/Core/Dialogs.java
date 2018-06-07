package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Dialog;
import net.pagala.JShikiApi.Items.MessageFull;
import net.pagala.JShikiApi.Items.Notice;

import static net.pagala.JShikiApi.Core.Shikimori.deleteItem;
import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Dialogs {

    private Dialogs() {

    }

    public static ApiCall<MessageFull[]> get(int userId) {
        return getItem("/dialogs/" + userId, MessageFull[].class);
    }

    public static ApiCall<MessageFull[]> get(String nickname) {
        return getItem("/dialogs/" + nickname, MessageFull[].class);
    }

    public static ApiCall<Dialog[]> getList() {
        return getItem("/dialogs", Dialog[].class);
    }

    public static ApiCall<Notice> delete(int userId) {
        return deleteItem("/dialogs/" + userId, Notice.class);
    }
}
