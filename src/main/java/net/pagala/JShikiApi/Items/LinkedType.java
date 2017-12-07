package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum LinkedType {
    @JsonProperty("Anime")
    ANIME,
    @JsonProperty("Manga")
    MANGA,
    @JsonProperty("Ranobe")
    RANOBE,
    @JsonProperty("Person")
    PERSON,
    @JsonProperty("Contest")
    CONTEST
}
