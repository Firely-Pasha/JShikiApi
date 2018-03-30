package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.pagala.JShikiApi.Items.TitleType;

public enum HistoryItemType {
    @JsonProperty("animes")
    ANIMES,
    @JsonProperty("mangas")
    MANGAS,
    @JsonProperty("ranobe")
    RANOBE,
    @JsonProperty("registration")
    OTHER,
    ;
}
