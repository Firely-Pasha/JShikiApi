package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by firely-pasha on 7/19/17.
 */
@SuppressWarnings("unused")
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

    private Character[] seyu;

    private AnimeWithRole[] animes;

    @JsonProperty("mangas")
    private MangaWithRole[] mangasAndRanobes;

    @JsonIgnore
    private List<MangaWithRole> mangas;

    @JsonIgnore
    private List<MangaWithRole> ranobes;

    private CharacterFull() {
        this.mangas = null;
        this.ranobes = null;
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

    public Character[] getSeyu() {
        return seyu;
    }

    public AnimeWithRole[] getAnimes() {
        return animes;
    }

    public List<MangaWithRole> getMangas() {
        if (mangas == null) {
            mangas = new ArrayList<>();
            for (MangaWithRole manga : mangasAndRanobes) {
                if (!manga.getKind().equals(MangaKind.NOVEL)) {
                    mangas.add(manga);
                }
            }
        }
        return mangas;
    }

    public List<MangaWithRole> getRanobes() {
        if (ranobes == null) {
            ranobes = new ArrayList<>();
            for (MangaWithRole ranobe : mangasAndRanobes) {
                if (ranobe.getKind().equals(MangaKind.NOVEL)) {
                    ranobes.add(ranobe);
                }
            }
        }
        return ranobes;
    }
}
