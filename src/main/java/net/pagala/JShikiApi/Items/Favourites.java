package net.pagala.JShikiApi.Items;

@SuppressWarnings("unused")
public class Favourites {
    private FavouriteItem[] animes;

    private FavouriteItem[] mangas;

    private FavouriteItem[] characters;

    private FavouriteItem[] people;

    private FavouriteItem[] mangakas;

    private FavouriteItem[] seyu;

    private FavouriteItem[] producers;

    private Favourites() {

    }

    public FavouriteItem[] getAnimes() {
        return animes;
    }

    public FavouriteItem[] getMangas() {
        return mangas;
    }

    public FavouriteItem[] getCharacters() {
        return characters;
    }

    public FavouriteItem[] getPeople() {
        return people;
    }

    public FavouriteItem[] getMangakas() {
        return mangakas;
    }

    public FavouriteItem[] getSeyu() {
        return seyu;
    }

    public FavouriteItem[] getProducers() {
        return producers;
    }
}
