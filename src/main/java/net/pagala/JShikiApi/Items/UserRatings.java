package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/19/17.
 */
@SuppressWarnings("unused")
public class UserRatings {
    @JsonProperty("anime")
    private UserTitleRating[] animes;

    private UserRatings() {

    }

    public UserTitleRating[] getAnimes() {
        return animes;
    }

    public static class UserTitleRating {
        private String name;
        private int value;

        private UserTitleRating() {

        }

        public String getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
}
