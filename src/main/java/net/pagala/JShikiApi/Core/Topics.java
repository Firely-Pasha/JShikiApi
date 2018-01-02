package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.ForumTypes;
import net.pagala.JShikiApi.Items.Topic;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Topics {

    private Topics() {

    }

    public static Topic get(int id) {
        return getItem("/topics/" + id, Topic.class);
    }

    // limit <= 30
    public static List<Topic> getList(ForumTypes forum, int limit, int page) {
        String url = "/topics?forum=" + forum + "&limit=" + limit + "&page=" + page;
        return getItemList(url, Topic[].class);
    }
}
