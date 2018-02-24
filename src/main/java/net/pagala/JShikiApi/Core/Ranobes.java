package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Filters.SearchFilter.MangaSearchFilter;
import net.pagala.JShikiApi.Items.*;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Ranobes {

    private Ranobes() {

    }

    public static MangaFull get(int id) {
        return getItem("/ranobe/" + id, MangaFull.class);
    }

    public static List<Manga> getList(MangaSearchFilter mangaSearchFilter) {
        return getItemList("/ranobe" + mangaSearchFilter.buildQuery(), Manga[].class);
    }

    public static List<Role> getRoles(int id) {
        return Shikimori.getItemList("/ranobe/" + id + "/roles", Role[].class);
    }

    public static List<Relation> getRelated(int id) {
        return Shikimori.getItemList("/ranobe/" + id + "/related", Relation[].class);
    }

    public static List<Manga> getSimilar(int id) {
        return Shikimori.getItemList("/ranobe/" + id + "/similar", Manga[].class);
    }

    //FIXME: URL!!!
    public static Franchise getFranchise(int id) {
        return Shikimori.getItem("/ranobe/" + id + "/franchise", Franchise.class);
    }

    public static List<ExternalLink> getExternalLinks(int id) {
        return Shikimori.getItemList("/ranobe/" + id + "/external_links", ExternalLink[].class);
    }
}
