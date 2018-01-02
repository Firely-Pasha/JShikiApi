package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.pagala.JShikiApi.Items.TitleType;

public enum HistoryItemType {
    @JsonProperty("anime")
    ANIME,
    @JsonProperty("manga")
    MANGA,
    @JsonProperty("ranobe")
    RANOBE,
    @JsonProperty("registration")
    REGISTRATION,
    ;
}
