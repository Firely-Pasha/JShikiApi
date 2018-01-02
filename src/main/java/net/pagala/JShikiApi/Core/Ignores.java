package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.databind.JsonNode;
import net.pagala.JShikiApi.Items.TopicIgnore;
import net.pagala.JShikiApi.Items.UserIgnore;

import java.io.IOException;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class Ignores {

    private Ignores() {

    }

    public static UserIgnore ignoreUser(int userId) {
        switchApiVersion(Shikimori.ApiVersion.V2);
        JsonNode response = postRequest("/users/" + userId + "/ignore", null, true);
        switchApiVersion(Shikimori.ApiVersion.V1);
        try {
            return mapper.readValue(response.toString(), UserIgnore.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static UserIgnore unignoreUser(int userId) {
        switchApiVersion(Shikimori.ApiVersion.V2);
        JsonNode response = deleteRequest("/users/" + userId + "/ignore", true);
        switchApiVersion(Shikimori.ApiVersion.V1);
        try {
            return mapper.readValue(response.toString(), UserIgnore.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static TopicIgnore ignoreTopic(int userId) {
        switchApiVersion(Shikimori.ApiVersion.V2);
        JsonNode response = postRequest("/topics/" + userId + "/ignore", null, true);
        switchApiVersion(Shikimori.ApiVersion.V1);
        try {
            return mapper.readValue(response.toString(), TopicIgnore.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static TopicIgnore unignoreTopic(int userId) {
        switchApiVersion(Shikimori.ApiVersion.V2);
        JsonNode response = deleteRequest("/topics/" + userId + "/ignore", true);
        switchApiVersion(Shikimori.ApiVersion.V1);
        try {
            return mapper.readValue(response.toString(), TopicIgnore.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
