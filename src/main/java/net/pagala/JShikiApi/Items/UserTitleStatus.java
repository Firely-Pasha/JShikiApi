package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

/**
 * Created by firely-pasha on 7/19/17.
 */

@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class UserTitleStatus {
    @JsonProperty("anime")
    private List<UserTitleTileStatus> animes;

    @JsonProperty("manga")
    private List<UserTitleTileStatus> mangas;


    private UserTitleStatus() {

    }

    public List<UserTitleTileStatus> getAnimes() {
        return animes;
    }

    public List<UserTitleTileStatus> getMangas() {
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
