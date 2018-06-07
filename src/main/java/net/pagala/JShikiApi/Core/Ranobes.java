package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Filters.SearchFilter.MangaSearchFilter;
import net.pagala.JShikiApi.Items.*;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Ranobes {

    private Ranobes() {

    }

    public static ApiCall<MangaFull> get(int id) {
        return getItem("/ranobe/" + id, MangaFull.class);
    }

    public static ApiCall<Manga[]> getList(MangaSearchFilter mangaSearchFilter) {
        return getItem("/ranobe" + mangaSearchFilter.buildQuery(), Manga[].class);
    }

    public static ApiCall<Role[]> getRoles(int id) {
        return getItem("/ranobe/" + id + "/roles", Role[].class);
    }

    public static ApiCall<Relation[]> getRelations(int id) {
        return getItem("/ranobe/" + id + "/related", Relation[].class);
    }

    public static ApiCall<Manga[]> getSimilar(int id) {
        return getItem("/ranobe/" + id + "/similar", Manga[].class);
    }

    public static ApiCall<Franchise> getFranchise(int id) {
        return getItem("/ranobe/" + id + "/franchise", Franchise.class);
    }

    public static ApiCall<ExternalLink[]> getExternalLinks(int id) {
        return getItem("/ranobe/" + id + "/external_links", ExternalLink[].class);
    }
}
