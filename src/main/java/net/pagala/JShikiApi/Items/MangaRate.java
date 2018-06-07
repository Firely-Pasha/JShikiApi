package net.pagala.JShikiApi.Items;

@SuppressWarnings("unused")
public class MangaRate extends TitleUserRate {
    private User user;

    private Anime anime;

    private Manga manga;

    private MangaRate() {

    }

    public User getUser() {
        return user;
    }

    public Anime getAnime() {
        return anime;
    }

    public Manga getManga() {
        return manga;
    }
}
