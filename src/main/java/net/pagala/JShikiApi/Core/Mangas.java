package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Filters.SearchFilter.MangaSearchFilter;
import net.pagala.JShikiApi.Items.*;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Mangas {

    private Mangas() {

    }

    public static MangaFull get(int id) {
        return getItem("/mangas/" + id, MangaFull.class);
    }

    public static List<Manga> getList(MangaSearchFilter mangaSearchFilter) {
        return getItemList("/mangas" + mangaSearchFilter.buildQuery(), Manga[].class);
    }

    public static List<Role> getRoles(int id) {
        return Shikimori.getItemList("/mangas/" + id + "/roles", Role[].class);
    }

    public static List<Relation> getRelations(int id) {
        return Shikimori.getItemList("/mangas/" + id + "/related", Relation[].class);
    }

    public static List<Manga> getSimilar(int id) {
        return Shikimori.getItemList("/mangas/" + id + "/similar", Manga[].class);
    }

    public static Franchise getFranchise(int id) {
        return Shikimori.getItem("/mangas/" + id + "/franchise", Franchise.class);
    }

    public static List<ExternalLink> getExternalLinks(int id) {
        return Shikimori.getItemList("/mangas/" + id + "/external_links", ExternalLink[].class);
    }
}
