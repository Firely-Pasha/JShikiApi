package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Notice {
    @JsonProperty("notice")
    private String notice;

    private Notice() {

    }

    public String get() {
        return notice;
    }
}
