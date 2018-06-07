package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
@SuppressWarnings("unused")
public class TitleUserRate {
    private Integer id;

    private Integer score;

    private TitleListStatus status;

    private String text;

    private Integer episodes;

    private Integer chapters;

    private Integer volumes;

    @JsonProperty("text_html")
    private String textHtml;

    private Integer rewatches;

    protected TitleUserRate() {

    }

    public Integer getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }

    public TitleListStatus getStatus() {
        return status;
    }

    public String getText() {
        return text;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public Integer getChapters() {
        return chapters;
    }

    public Integer getVolumes() {
        return volumes;
    }

    public String getTextHtml() {
        return textHtml;
    }

    public Integer getRewatches() {
        return rewatches;
    }
}
