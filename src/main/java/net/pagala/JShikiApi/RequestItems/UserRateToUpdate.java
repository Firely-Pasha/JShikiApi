package net.pagala.JShikiApi.RequestItems;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.pagala.JShikiApi.Core.Shikimori;
import net.pagala.JShikiApi.Items.TitleListStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRateToUpdate {
    private Integer score;

    private TitleListStatus status;

    private String text;

    private Integer episodes;

    private Integer chapters;

    private Integer volumes;

    private Integer rewatches;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public TitleListStatus getStatus() {
        return status;
    }

    public void setStatus(TitleListStatus status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public Integer getChapters() {
        return chapters;
    }

    public void setChapters(Integer chapters) {
        this.chapters = chapters;
    }

    public Integer getVolumes() {
        return volumes;
    }

    public void setVolumes(Integer volumes) {
        this.volumes = volumes;
    }

    public Integer getRewatches() {
        return rewatches;
    }

    public void setRewatches(Integer rewatches) {
        this.rewatches = rewatches;
    }
}
