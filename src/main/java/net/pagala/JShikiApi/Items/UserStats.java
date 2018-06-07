package net.pagala.JShikiApi.Items;

import net.pagala.JShikiApi.Core.Shikimori;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by firely-pasha on 7/19/17.
 */
@SuppressWarnings("unused")
public class UserStats {
    private UserTitleStatus statuses;

    @JsonProperty("full_statuses")
    private UserTitleStatus fullStatuses;

    private UserScores scores;

    private UserTypes types;

    private UserRatings ratings;

    @JsonProperty("has_anime?")
    private boolean hasAnime;

    @JsonProperty("has_manga?")
    private boolean hasManga;

    private Object[] genres;

    private Object[] studios;

    private Object[] publishers;

    @JsonProperty("activity")
    private JsonNode activities;


    private UserStats() {
    }
    //private List<UserActivity> userActivity;


    public UserTitleStatus getStatuses() {
        return statuses;
    }

    public UserTitleStatus getFullStatuses() {
        return fullStatuses;
    }

    public UserScores getScores() {
        return scores;
    }

    public UserTypes getTypes() {
        return types;
    }

    public UserRatings getRatings() {
        return ratings;
    }

    public boolean isHasAnime() {
        return hasAnime;
    }

    public boolean isHasManga() {
        return hasManga;
    }

    public Object[] getGenres() {
        return genres;
    }

    public Object[] getStudios() {
        return studios;
    }

    public Object[] getPublishers() {
        return publishers;
    }

    public UserActivity[] getActivities() {
        if (activities.asText().equals("")) {
            try {
                return Shikimori.getObjectMapper().treeToValue(activities, UserActivity[].class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }
        return new UserActivity[0];
    }
}
