package net.pagala.JShikiApi.RequestItems;

import com.fasterxml.jackson.annotation.JsonInclude;
import net.pagala.JShikiApi.Core.Shikimori;
import net.pagala.JShikiApi.Items.TargetType;
import net.pagala.JShikiApi.Items.TitleListStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRateToCreate {
    private Integer score;

    protected TitleListStatus status;

    private String text;

    private Integer episodes;

    private Integer chapters;

    private Integer volumes;

    private Integer rewatches;

    @JsonProperty("target_id")
    private int targetId;

    @JsonProperty("target_type")
    private TargetType targetType;

    @JsonProperty("user_id")
    private int userId;

    public UserRateToCreate(int userId, int targetId, TargetType targetType) {
        this.userId = userId;
        this.targetId = targetId;
        this.targetType = targetType;
    }

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

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
