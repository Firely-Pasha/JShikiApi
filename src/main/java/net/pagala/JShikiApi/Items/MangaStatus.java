package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MangaStatus {
    @JsonProperty("planned")
    PLANNED,
    @JsonProperty("reading")
    READING,
    @JsonProperty("rereading")
    REREADING,
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
