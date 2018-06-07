package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.*;
import net.pagala.JShikiApi.Items.Character;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;
import static net.pagala.JShikiApi.Core.Shikimori.postItem;

public final class Clubs {

    private Clubs() {

    }

    public static ApiCall<ClubFull> get(int id) {
        return getItem("/clubs/" + id, ClubFull.class);
    }

    public static ApiCall<Club[]> getList(int limit, int page) {
        return getItem("/clubs?limit=" + limit + "&page=" + page, Club[].class);
    }

    public static ApiCall<Club[]> getList(int limit, int page, String searchString) {
        String url = "/clubs?limit=" + limit + "&page=" + page + "&search=" + searchString;
        return getItem(url, Club[].class);
    }

    private ApiCall<Anime[]> getAnimes(int id) {
        return getItem("/clubs/" + id + "/animes", Anime[].class);
    }

    private ApiCall<Manga[]> getMangas(int id) {
        return getItem("/clubs/" + id + "/mangas", Manga[].class);
    }

    //TODO: No such property.
    private ApiCall<Manga[]> getRanobes(int id) {
        return getItem("/clubs/" + id + "/ranobe", Manga[].class);
    }

    private ApiCall<Character[]> getCharacters(int id) {
        return getItem("/clubs/" + id + "/characters", Character[].class);
    }

    //TODO: Implement limit and page for this.
    private ApiCall<User[]> getMembers(int id) {
        return getItem("/clubs/" + id + "/members", User[].class);
    }

    private ApiCall<Image[]> getImages(int id) {
        return getItem("/clubs/" + id + "/images", Image[].class);
    }

    //TODO: Check for double join.
    public ApiCall join(int id) {
        return postItem("/clubs/" + id + "/join", null, null);
    }

    //TODO: Check for double leave.
    public ApiCall leave(int id) {
        return postItem("/clubs/" + id + "/leave", null, null);
    }

}
