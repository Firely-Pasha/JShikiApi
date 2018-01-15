package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum AnimeKind {
    @JsonProperty("tv")
    TV,

    @JsonProperty("movie")
    MOVIE,

    @JsonProperty("ova")
    OVA,

    @JsonProperty("ona")
    ONA,

    @JsonProperty("special")
    SPECIAL,

    @JsonProperty("music")
    MUSIC,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
