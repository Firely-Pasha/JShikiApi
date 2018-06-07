package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/19/17.
 */
@SuppressWarnings("unused")
public class UserScores {
    @JsonProperty("anime")
    private UserTitleScores[] animes;

    @JsonProperty("manga")
    private UserTitleScores[] mangas;

    private UserScores() {

    }

    public UserTitleScores[] getAnimes() {
        return animes;
    }

    public UserTitleScores[] getMangas() {
        return mangas;
    }

    public static class UserTitleScores {
        private int name;
        private int value;

        private UserTitleScores() {

        }

        public int getName() {
            return name;
        }

        public int getValue() {
            return value;
        }
    }
}
