package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TitleListStatus {
    @JsonProperty("planned")
    PLANNED,
    @JsonProperty("watching")
    WATCHING,
    @JsonProperty("rewatching")
    REWATCHING,
    @JsonProperty("completed")
    COMPLETED,
    @JsonProperty("on_hold")
    ON_HOLD,
    @JsonProperty("dropped")
    DROPPED,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
