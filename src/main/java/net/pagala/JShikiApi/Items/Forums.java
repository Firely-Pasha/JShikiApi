package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Forums {
    @JsonProperty("all")
    ALL,

    @JsonProperty("offtopic")
    OFFTOPIC,

    @JsonProperty("animanga")
    ANIMANGA,

    @JsonProperty("site")
    SITE,

    @JsonProperty("games")
    GAMES,

    @JsonProperty("vn")
    VN,

    @JsonProperty("contests")
    CONTESTS,

    @JsonProperty("clubs")
    CLUBS,

    @JsonProperty("my_clubs")
    MY_CLUBS,

    @JsonProperty("reviews")
    REVIEWS,

    @JsonProperty("news")
    NEWS,

    @JsonProperty("collections")
    COLLECTIONS,

    @JsonProperty("cosplay")
    COSPLAY
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
