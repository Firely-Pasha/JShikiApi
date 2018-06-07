package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Filters.SearchFilter.AnimeSearchFilter;
import net.pagala.JShikiApi.Items.*;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Animes {

    private Animes() {

    }

    public static ApiCall<AnimeFull> get(int id) {
        return getItem("/animes/" + id, AnimeFull.class);
    }

    public static ApiCall<Anime[]> getList(AnimeSearchFilter animeSearchFilter) {
        return getItem("/animes" + animeSearchFilter.buildQuery(), Anime[].class);
    }


    public static ApiCall<Role[]> getRoles(int id) {
        return getItem("/animes/" + id + "/roles", Role[].class);
    }

    public static ApiCall<Relation[]> getRelations(int id) {
        return getItem("/animes/" + id + "/related", Relation[].class);
    }

    public static ApiCall<Anime[]> getSimilar(int id) {
        return getItem("/animes/" + id + "/similar", Anime[].class);
    }

    public static ApiCall<Franchise> getFranchise(int id) {
        return getItem("/animes/" + id + "/franchise", Franchise.class);
    }

    public static ApiCall<ExternalLink[]> getExternalLinks(int id) {
        return getItem("/animes/" + id + "/external_links", ExternalLink[].class);
    }
}
