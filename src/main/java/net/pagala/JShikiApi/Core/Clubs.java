package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.*;
import net.pagala.JShikiApi.Items.Character;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItemList;
import static net.pagala.JShikiApi.Core.Shikimori.postRequest;

public final class Clubs {

    private Clubs() {

    }

    public static ClubFull get(int id) {
        return Shikimori.getItem("/clubs/" + id, ClubFull.class);
    }

    public static List<Club> getList(int limit, int page) {
        return getItemList("/clubs?limit=" + limit + "&page=" + page, Club[].class);
    }

    public static List<Club> getList(int limit, int page, String searchString) {
        String url = "/clubs?limit=" + limit + "&page=" + page + "&search=" + searchString;
        return getItemList(url, Club[].class);
    }

    private List<Anime> getAnimes(int id) {
        return getItemList("/clubs/" + id + "/animes", Anime[].class);
    }

    private List<Manga> getMangas(int id) {
        return getItemList("/clubs/" + id + "/mangas", Manga[].class);
    }

    //TODO: No such property.
    private List<Manga> getRanobes(int id) {
        return getItemList("/clubs/" + id + "/ranobe", Manga[].class);
    }

    private List<Character> getCharacters(int id) {
        return getItemList("/clubs/" + id + "/characters", Character[].class);
    }

    //TODO: Implement limit and page for this.
    private List<User> getMembers(int id) {
        return getItemList("/clubs/" + id + "/members", User[].class);
    }

    private List<Image> getImages(int id) {
        return getItemList("/clubs/" + id + "/images", Image[].class);
    }

    //TODO: Check for double join.
    public void join(int id) {
        postRequest("/clubs/" + id + "/join", null, false);
    }

    //TODO: Check for double leave.
    public void leave(int id) {
        postRequest("/clubs/" + id + "/leave", null, false);
    }

}
