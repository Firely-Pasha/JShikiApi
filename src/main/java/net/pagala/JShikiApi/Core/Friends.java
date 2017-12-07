package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.databind.JsonNode;

import static net.pagala.JShikiApi.Core.Shikimori.deleteRequest;
import static net.pagala.JShikiApi.Core.Shikimori.postRequest;

public class Friends {
    private Friends() {

    }

    public static JsonNode addFriend(int friendId) {
        return postRequest("/friends/" + friendId, null, true);
    }

    public static JsonNode removeFriend(int friendId) {
        return deleteRequest("/friends/" + friendId, true);
    }
}