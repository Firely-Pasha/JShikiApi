package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by firely-pasha on 7/18/17.
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Node {
    private int id;

    private int date;

    private String name;

    @JsonProperty("image_url")
    private String imageUrl;

    private String url;

    private int year;

    private String kind;

    private int weight;


    private Node() {

    }

    public int getId() {
        return id;
    }

    public int getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getUrl() {
        return url;
    }

    public int getYear() {
        return year;
    }

    public String getKind() {
        return kind;
    }

    public int getWeight() {
        return weight;
    }
}
