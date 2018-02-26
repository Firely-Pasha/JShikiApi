package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClubsImage {
    private int id;

    @JsonProperty("original_url")
    private String originalUrl;

    @JsonProperty("main_url")
    private String mainUrl;

    @JsonProperty("preview_url")
    private String previewUrl;

    private String original;

    private String main;

    private String preview;

    @JsonProperty("can_destroy")
    private boolean canDestroy;

    private ClubsImage() {

    }

    public int getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getMainUrl() {
        return mainUrl;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public String getOriginal() {
        return original;
    }

    public String getMain() {
        return main;
    }

    public String getPreview() {
        return preview;
    }
}
