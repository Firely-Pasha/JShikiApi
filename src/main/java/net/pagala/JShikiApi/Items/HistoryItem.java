package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.Date;

import static net.pagala.JShikiApi.Core.Shikimori.getObjectMapper;

@SuppressWarnings("unused")
public class HistoryItem {
    private int id;

    @JsonProperty("created_at")
    private Date createdAt;

    private String description;

    //TODO: Make something with difference.
    private JsonNode target;

    private HistoryItem() {

    }

    public HistoryItemType getType() {
        if (target != null && target.get("url") != null) {
            StringBuilder sb = new StringBuilder(target.get("url").asText());
            sb.delete(0, 1);
            String type = sb.substring(0, sb.indexOf("/"));
            return HistoryItemType.valueOf(type.toUpperCase());
        } else {
            return HistoryItemType.OTHER;
        }
    }

    public int getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getDescription() {
        return description;
    }

    public JsonNode getTarget() {
        return target;
    }

    public Anime getAnime() {
        try {
            HistoryItemType type = getType();
            if (type == HistoryItemType.ANIMES) {
                return getObjectMapper().treeToValue(target, Anime.class);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Manga getManga() {
        try {
            HistoryItemType type = getType();
            if (type == HistoryItemType.MANGAS) {
                return getObjectMapper().treeToValue(target, Manga.class);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Manga getRanobe() {
        try {
            HistoryItemType type = getType();
            if (type == HistoryItemType.RANOBE) {
                return getObjectMapper().treeToValue(target, Manga.class);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
