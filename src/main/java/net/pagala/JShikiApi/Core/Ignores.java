package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.TopicIgnore;
import net.pagala.JShikiApi.Items.UserIgnore;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class Ignores {

    private Ignores() {

    }

    public static ApiCall<UserIgnore> ignoreUser(int userId) {
        return postItem("/users/" + userId + "/ignore", "", UserIgnore.class);
    }

    public static ApiCall<UserIgnore> unignoreUser(int userId) {
        return deleteItem("/users/" + userId + "/ignore", UserIgnore.class);
    }

    public static ApiCall<TopicIgnore> ignoreTopic(int topicId) {
        return postItem("/topics/" + topicId + "/ignore", "", TopicIgnore.class);
    }

    public static ApiCall<TopicIgnore> unignoreTopic(int topicId) {
        return deleteItem("/topics/" + topicId + "/ignore", TopicIgnore.class);
    }
}
