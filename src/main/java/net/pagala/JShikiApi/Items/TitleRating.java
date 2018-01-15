package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
public enum TitleRating {
    @JsonProperty("none")
    NONE,

    @JsonProperty("g")
    G,

    @JsonProperty("pg")
    PG,

    @JsonProperty("pg_13")
    PG_13,

    @JsonProperty("r")
    R,

    @JsonProperty("r_plus")
    R_PLUS,

    @JsonProperty("rx")
    RX,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}