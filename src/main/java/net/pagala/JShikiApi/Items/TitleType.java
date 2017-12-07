package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
public enum TitleType {
    @JsonProperty("anime")
    ANIME,
    @JsonProperty("manga")
    MANGA,
    @JsonProperty("ranobe")
    RANOBE,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
