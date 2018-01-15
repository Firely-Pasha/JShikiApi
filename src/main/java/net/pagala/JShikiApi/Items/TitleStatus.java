package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
public enum  TitleStatus {
    @JsonProperty("anons")
    ANONS,

    @JsonProperty("ongoing")
    ONGOING,

    @JsonProperty("released")
    RELEASED,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
