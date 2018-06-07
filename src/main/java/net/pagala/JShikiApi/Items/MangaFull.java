package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/17/17.
 */
@SuppressWarnings("unused")
public class MangaFull extends Manga implements TitleFull {
    private String[] english;

    private String[] japanese;

    private String[] synonyms;

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
    private RatesStatus[] ratesStatusesStats;

    @JsonProperty("rates_scores_stats")
    private RatesScore[] ratesScoresStats;

    private Genre[] genres;

    @JsonProperty("user_rate")
    private TitleUserRate titleUserRate;

    private Publisher[] publishers;


    private MangaFull() {

    }

    @Override
    public String[] getEnglish() {
        return english;
    }

    @Override
    public String[] getJapanese() {
        return japanese;
    }

    @Override
    public String[] getSynonyms() {
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
    public RatesStatus[] getRatesStatusesStats() {
        return ratesStatusesStats;
    }

    @Override
    public RatesScore[] getRatesScoresStats() {
        return ratesScoresStats;
    }

    @Override
    public Genre[] getGenres() {
        return genres;
    }

    @Override
    public TitleUserRate getTitleUserRate() {
        return titleUserRate;
    }

    public Publisher[] getPublishers() {
        return publishers;
    }
}
