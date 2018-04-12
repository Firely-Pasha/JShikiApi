package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.TopicIgnore;
import net.pagala.JShikiApi.Items.UserIgnore;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class Ignores {

    private Ignores() {

    }

    public static UserIgnore ignoreUser(int userId) {
        switchApiVersion(RequestVersion.API_V2);
        return postItem("/users/" + userId + "/ignore", null, UserIgnore.class, true);
    }

    public static UserIgnore unignoreUser(int userId) {
        switchApiVersion(RequestVersion.API_V2);
        return deleteItem("/users/" + userId + "/ignore", UserIgnore.class, true);
    }

    public static TopicIgnore ignoreTopic(int topicId) {
        switchApiVersion(RequestVersion.API_V2);
        return postItem("/topics/" + topicId + "/ignore", null, TopicIgnore.class, true);
    }

    public static TopicIgnore unignoreTopic(int topicId) {
        switchApiVersion(RequestVersion.API_V2);
        return deleteItem("/topics/" + topicId + "/ignore", TopicIgnore.class, true);
    }
}
