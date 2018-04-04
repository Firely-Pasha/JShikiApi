package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

/**
 *
 * Created by firely-pasha on 7/19/17.
 */
@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class UserScores {
    @JsonProperty("anime")
    private List<UserTitleScores> animes;

    @JsonProperty("manga")
    private List<UserTitleScores> mangas;

    private UserScores() {

    }

    public List<UserTitleScores> getAnimes() {
        return animes;
    }

    public List<UserTitleScores> getMangas() {
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
