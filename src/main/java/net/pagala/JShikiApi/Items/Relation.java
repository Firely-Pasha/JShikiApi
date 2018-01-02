package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/13/17.
 */
@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Relation {
    private String relation;

    @JsonProperty("relation_russian")
    private String relationRussian;

    private Anime anime;

    private Manga manga;


    private Relation() {

    }

    public String getRelation() {
        return relation;
    }

    public String getRelationRussian() {
        return relationRussian;
    }

    public Anime getAnime() {
        return anime;
    }

    public Manga getManga() {
        return manga;
    }
}
