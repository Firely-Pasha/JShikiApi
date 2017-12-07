package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by firely-pasha on 7/15/17.
 */
@SuppressWarnings({"unused", "Duplicates"})
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Anime implements Title {

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

    private int episodes;

    @JsonProperty("episodes_aired")
    private int episodesAired;

    protected Anime() {

    }

    public List<Role> getRoles() {
        return Shikimori.getItemList("/animes/" + getId() + "/roles", Role[].class);
    }

    public List<Relation> getRelations() {
        return Shikimori.getItemList("/animes/" + getId() + "/related", Relation[].class);
    }

    public List<Anime> getSimilar() {
        return Shikimori.getItemList("/animes/" + getId() + "/similar", Anime[].class);
    }

    @Override
    public Franchise getFranchise() {
        return Shikimori.getItem("/animes/" + getId() + "/external_links", Franchise.class);
    }

    @Override
    public List<ExternalLink> getExternalLinks() {
        return Shikimori.getItemList("/animes/" + getId() + "/external_links", ExternalLink[].class);
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

    public int getEpisodes() {
        return episodes;
    }

    public int getEpisodesAired() {
        return episodesAired;
    }
}
