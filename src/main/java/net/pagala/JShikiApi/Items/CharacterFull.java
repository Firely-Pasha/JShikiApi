package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 *
 * Created by firely-pasha on 7/19/17.
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterFull extends Character{
    private String altname;

    private String japanese;

    private String description;

    @JsonProperty("description_html")
    private String descriptionHtml;

    @JsonProperty("description_source")
    private String descriptionSource;

    private String favoured;

    @JsonProperty("thread_id")
    private int threadId;

    @JsonProperty("topic_id")
    private int topicId;

    @JsonProperty("updated_at")
    private Date updatedAt;

    private List<Character> seyu;

    private List<Anime> animes;

    private List<Manga> mangas;

    private CharacterFull() {

    }

    public String getAltname() {
        return altname;
    }

    public String getJapanese() {
        return japanese;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    public String getDescriptionSource() {
        return descriptionSource;
    }

    public String getFavoured() {
        return favoured;
    }

    public int getThreadId() {
        return threadId;
    }

    public int getTopicId() {
        return topicId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public List<Character> getSeyu() {
        return seyu;
    }

    public List<Anime> getAnimes() {
        return animes;
    }

    public List<Manga> getMangas() {
        return mangas;
    }
}
