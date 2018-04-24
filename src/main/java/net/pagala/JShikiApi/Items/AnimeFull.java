package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */

@SuppressWarnings("unused")
public class AnimeFull extends Anime implements TitleFull {

    private List<String> english;

    private List<String> japanese;

    private List<String> synonyms;

    private String score;

    private String description;

    @JsonProperty("description_html")
    private String descriptionHtml;

    @JsonProperty("description_source")
    private String descriptionSource;

    private boolean favoured;

    private boolean anons;

    private boolean ongoing;

    @JsonProperty("thread_id")
    private int threadId;

    @JsonProperty("topic_id")
    private int topicId;

    @JsonProperty("myanimelist_id")
    private int myanimelistId;

    @JsonProperty("rates_statuses_stats")
    private List<RatesStatus> ratesStatusesStats;

    @JsonProperty("rates_scores_stats")
    private List<RatesScore> ratesScoresStats;

    private List<Genre> genres;

    @JsonProperty("user_rate")
    private TitleUserRate titleUserRate;

    private AnimeRating rating;

    private int duration;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("next_episode_at")
    private String nextEpisodeAt;

    private List<Studio> studios;

    private List<Video> videos;

    private List<Screenshot> screenshots;


    private AnimeFull() {
    }

    public AnimeRating getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getNextEpisodeAt() {
        return nextEpisodeAt;
    }

    public List<Studio> getStudios() {
        return studios;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public List<Screenshot> getScreenshots() {
        return screenshots;
    }

    @Override
    public List<String> getEnglish() {
        return english;
    }

    @Override
    public List<String> getJapanese() {
        return japanese;
    }

    @Override
    public List<String> getSynonyms() {
        return synonyms;
    }

    @Override
    public String getScore() {
        return score;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    @Override
    public String getDescriptionSource() {
        return descriptionSource;
    }

    @Override
    public boolean isFavoured() {
        return favoured;
    }

    @Override
    public boolean isAnons() {
        return anons;
    }

    @Override
    public boolean isOngoing() {
        return ongoing;
    }

    @Override
    public int getThreadId() {
        return threadId;
    }

    @Override
    public int getTopicId() {
        return topicId;
    }

    @Override
    public int getMyanimelistId() {
        return myanimelistId;
    }

    @Override
    public List<RatesStatus> getRatesStatusesStats() {
        return ratesStatusesStats;
    }

    @Override
    public List<RatesScore> getRatesScoresStats() {
        return ratesScoresStats;
    }

    @Override
    public List<Genre> getGenres() {
        return genres;
    }

    @Override
    public TitleUserRate getTitleUserRate() {
        return titleUserRate;
    }
}
