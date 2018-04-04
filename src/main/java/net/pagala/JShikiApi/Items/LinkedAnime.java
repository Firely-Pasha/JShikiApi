package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class LinkedAnime extends LinkedItem implements Title {
    private String name;

    private String russian;

    private Image image;

    private String url;

    private AnimeKind kind;

    private TitleStatus status;

    private int episodes;

    @JsonProperty("episodes_aired")
    private int episodesAired;

    @JsonProperty("aired_on")
    private Date airedOn;

    @JsonProperty("released_on")
    private Date releasedOn;

    private LinkedAnime() {

    }

    public String getName() {
        return name;
    }

    public String getRussian() {
        return russian;
    }

    public Image getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }

    public AnimeKind getKind() {
        return kind;
    }

    public TitleStatus getStatus() {
        return status;
    }

    public int getEpisodes() {
        return episodes;
    }

    public int getEpisodesAired() {
        return episodesAired;
    }

    public Date getAiredOn() {
        return airedOn;
    }

    public Date getReleasedOn() {
        return releasedOn;
    }
}
