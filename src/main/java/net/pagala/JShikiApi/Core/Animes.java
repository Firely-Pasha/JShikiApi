package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Filters.SearchFilter.AnimeSearchFilter;
import net.pagala.JShikiApi.Items.*;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Animes {

    private Animes() {

    }

    public static AnimeFull get(int id) {
        return getItem("/animes/" + id, AnimeFull.class);
    }

    public static List<Anime> getList(AnimeSearchFilter animeSearchFilter) {
        return getItemList("/animes" + animeSearchFilter.buildQuery(), Anime[].class);
    }


    public static List<Role> getRoles(int id) {
        return getItemList("/animes/" + id + "/roles", Role[].class);
    }

    public static List<Relation> getRelations(int id) {
        return getItemList("/animes/" + id + "/related", Relation[].class);
    }

    public static List<Anime> getSimilar(int id) {
        return getItemList("/animes/" + id + "/similar", Anime[].class);
    }

    public static Franchise getFranchise(int id) {
        return getItem("/animes/" + id + "/franchise", Franchise.class);
    }

    public static List<ExternalLink> getExternalLinks(int id) {
        return getItemList("/animes/" + id + "/external_links", ExternalLink[].class);
    }
}
