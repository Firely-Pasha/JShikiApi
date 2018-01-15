package net.pagala.JShikiApi.RequestItems;

import net.pagala.JShikiApi.Core.Shikimori;
import net.pagala.JShikiApi.Filters.UserRateFilter.TargetType;
import net.pagala.JShikiApi.Items.TitleListStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@SuppressWarnings("unused")
public class UserRateToCreate {
    protected Integer score;

    protected TitleListStatus status;

    protected String text;

    protected Integer episodes;

    protected Integer chapters;

    protected Integer volumes;

    protected Integer rewatches;

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

    public String build() {
        ObjectMapper mapper = Shikimori.getObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();

        JsonNode userRate = mapper.createObjectNode();
        ((ObjectNode)userRate).put("user_id", userId);
        ((ObjectNode)userRate).put("target_id", targetId);
        ((ObjectNode)userRate).put("target_type", targetType.toString());

        if (status != null) {
            ((ObjectNode)userRate).put("status", status.toString());
        }
        if (score != null) {
            ((ObjectNode)userRate).put("score", score);
        }
        if (chapters != null) {
            ((ObjectNode)userRate).put("chapters", chapters);
        }
        if (episodes != null) {
            ((ObjectNode)userRate).put("episodes", episodes);
        }
        if (volumes != null) {
            ((ObjectNode)userRate).put("volumes", volumes);
        }
        if (rewatches != null) {
            ((ObjectNode)userRate).put("rewatches", rewatches);
        }
        if (text != null) {
            ((ObjectNode)userRate).put("text", text);
        }

        ((ObjectNode)rootNode).set("user_rate", userRate);

        String jsonString = null;
        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;

    }
}
