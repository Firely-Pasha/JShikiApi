package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MangaKind {

    @JsonProperty("manga")
    MANGA,

    @JsonProperty("manhwa")
    MANHWA,

    @JsonProperty("manhua")
    MANHUA,

    @JsonProperty("novel")
    NOVEL,

    @JsonProperty("one_shot")
    ONE_SHOT,

    @JsonProperty("doujin")
    DOUJIN,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
