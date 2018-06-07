package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by firely-pasha on 7/19/17.
 */

@SuppressWarnings("unused")
public class UserTitleStatus {
    @JsonProperty("anime")
    private UserTitleTileStatus[] animes;

    @JsonProperty("manga")
    private UserTitleTileStatus[] mangas;


    private UserTitleStatus() {

    }

    public UserTitleTileStatus[] getAnimes() {
        return animes;
    }

    public UserTitleTileStatus[] getMangas() {
        return mangas;
    }

    public static class UserTitleTileStatus {
        private int id;

        private String name;

        private int size;

        @JsonProperty("grouped_id")
        private String groupedId;

        private String type;


        private UserTitleTileStatus() {

        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getSize() {
            return size;
        }

        public String getGroupedId() {
            return groupedId;
        }

        public String getType() {
            return type;
        }
    }
}
