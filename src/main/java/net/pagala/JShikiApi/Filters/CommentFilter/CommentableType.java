package net.pagala.JShikiApi.Filters.CommentFilter;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public enum CommentableType {
    @JsonProperty("Topic")
    TOPIC("Topic"),
    @JsonProperty("User")
    USER("User"),
    @JsonProperty("Anime")
    ANIME("Anime"),
    @JsonProperty("Manga")
    MANGA("Manga"),
    @JsonProperty("Character")
    CHARACTER("Character"),
    @JsonProperty("Person")
    PERSON("Person"),
    @JsonProperty("Club")
    CLUB("Club"),
    ;

    private String string;

    private CommentableType(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
