package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.ForumTypes;
import net.pagala.JShikiApi.Items.Topic;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Topics {

    private Topics() {

    }

    public static ApiCall<Topic> get(int id) {
        return getItem("/topics/" + id, Topic.class);
    }

    // limit <= 30
    public static ApiCall<Topic[]> getList(ForumTypes forum, int limit, int page) {
        String url = "/topics?forum=" + forum + "&limit=" + limit + "&page=" + page;
        return getItem(url, Topic[].class);
    }
}
