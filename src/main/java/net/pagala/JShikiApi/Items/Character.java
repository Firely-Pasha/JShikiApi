package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * Created by firely-pasha on 7/13/17.
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    private int id;

    private String name;

    private String russian;

    private Image image;

    private String url;

    protected Character() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRussian() {
        return russian;
    }

    public Image getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }
}
