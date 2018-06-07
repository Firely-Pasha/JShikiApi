package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CalendarItem {
    @JsonProperty("next_episode")
    private int nextEpisode;

    @JsonProperty("next_episode_at")
    private Date nextEpisodeAt;

    private String duration;

    private Anime anime;

    private CalendarItem() {
    }

    public int getNextEpisode() {
        return nextEpisode;
    }

    public Date getNextEpisodeAt() {
        return nextEpisodeAt;
    }

    /**
     * @return string value 'cause some items have duration value like "31/1440".
     */
    public String getDuration() {
        return duration;
    }

    public Anime getAnime() {
        return anime;
    }
}