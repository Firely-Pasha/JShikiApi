package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by firely-pasha on 7/19/17.
 */
@SuppressWarnings("unused")
public class UserTypes {
    @JsonProperty("anime")
    private UserTitleTypes[] animes;

    @JsonProperty("manga")
    private UserTitleTypes[] mangas;


    private UserTypes() {

    }

    public UserTitleTypes[] getAnimes() {
        return animes;
    }

    public UserTitleTypes[] getMangas() {
        return mangas;
    }

    public static class UserTitleTypes {
        private String name;
        private String value;

        private UserTitleTypes() {

        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }
}
