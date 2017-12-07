package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Video {
    private int id;

    private String url;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("player_url")
    private String playerUrl;

    private String name;

    private String kind;

    private String hosting;

    private Video() {

    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getPlayerUrl() {
        return playerUrl;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public String getHosting() {
        return hosting;
    }
}
