package net.pagala.JShikiApi.RequestItems;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.pagala.JShikiApi.Core.Shikimori;
import net.pagala.JShikiApi.Items.TitleStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class UserRateToUpdate {
    protected Integer score;

    protected TitleStatus status;

    protected String text;

    protected Integer episodes;

    protected Integer chapters;

    protected Integer volumes;

    protected Integer rewatches;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public TitleStatus getStatus() {
        return status;
    }

    public void setStatus(TitleStatus status) {
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

    public String build() {
        ObjectMapper mapper = Shikimori.getObjectMapper();
        JsonNode rootNode = mapper.createObjectNode();

        JsonNode userRate = mapper.createObjectNode();

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
