package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Notice;

import static net.pagala.JShikiApi.Core.Shikimori.deleteItem;
import static net.pagala.JShikiApi.Core.Shikimori.postItem;

public final class Friends {

    private Friends() {

    }

    // {
    //  "notice": "user_1234567 добавлен в друзья"
    // }
    public static ApiCall<Notice> add(int friendId) {
        return postItem("/friends/" + friendId, "", Notice.class);
    }

    public static ApiCall<Notice> remove(int friendId) {
        return deleteItem("/friends/" + friendId, Notice.class);
    }
}