package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public enum  TargetType {
    @JsonProperty("Anime")
    ANIME("Anime"),
    @JsonProperty("Manga")
    MANGA("Manga"),
    ;

    private String string;

    private TargetType(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
