package net.pagala.JShikiApi.Items;

import net.pagala.JShikiApi.Core.Shikimori;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by firely-pasha on 7/17/17.
 */

//TODO: Implement for character finding with role field.
@SuppressWarnings({"unused", "Duplicates"})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Manga implements Title {
    private int id;

    private String name;

    private String russian;

    private Image image;

    private String url;

    private String kind;

    private String status;

    @JsonProperty("aired_on")
    private Date airedOn;

    @JsonProperty("released_on")
    private Date releasedOn;

    private int volumes;

    private int chapters;


    protected Manga() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRussian() {
        return russian;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getKind() {
        return kind;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public Date getAiredOn() {
        return airedOn;
    }

    @Override
    public Date getReleasedOn() {
        return releasedOn;
    }

    public int getVolumes() {
        return volumes;
    }

    public int getChapters() {
        return chapters;
    }
}
