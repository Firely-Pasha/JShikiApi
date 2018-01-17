package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 *
 * Created by firely-pasha on 7/15/17.
 */
@SuppressWarnings({"unused", "Duplicates"})
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Anime extends Unit implements Title {

    private AnimeKind kind;

    private TitleStatus status;

    @JsonProperty("aired_on")
    private Date airedOn;

    @JsonProperty("released_on")
    private Date releasedOn;

    private int episodes;

    @JsonProperty("episodes_aired")
    private int episodesAired;

    protected Anime() {

    }

    @Override
    public TitleStatus getStatus() {
        return status;
    }

    @Override
    public Date getAiredOn() {
        return airedOn;
    }

    @Override
    public Date getReleasedOn() {
        return releasedOn;
    }

    public AnimeKind getKind() {
        return kind;
    }


    public int getEpisodes() {
        return episodes;
    }

    public int getEpisodesAired() {
        return episodesAired;
    }
}
