package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnimeVideo {
    private int id;

    @JsonProperty("anime_id")
    private int animeId;

    private String url;

    private String source;

    private int episode;

    private String kind;

    private String language;

    private String quality;

    private String state;

    @JsonProperty("author_name")
    private String authorName;

    private AnimeVideo() {

    }

    public int getId() {
        return id;
    }

    public int getAnimeId() {
        return animeId;
    }

    public String getUrl() {
        return url;
    }

    public String getSource() {
        return source;
    }

    public int getEpisode() {
        return episode;
    }

    public String getKind() {
        return kind;
    }

    public String getLanguage() {
        return language;
    }

    public String getQuality() {
        return quality;
    }

    public String getState() {
        return state;
    }

    public String getAuthorName() {
        return authorName;
    }
}
