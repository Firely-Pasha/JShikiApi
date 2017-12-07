package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum MessageKind {
    @JsonProperty("Private")
    PRIVATE("Private"),
    ;

    private String string;

    private MessageKind(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
