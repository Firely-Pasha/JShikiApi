package net.pagala.JShikiApi.Usr;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("unused")
public class Favourites {
	private List<FavouriteItem> animes;

	private List<FavouriteItem> mangas;

	private List<FavouriteItem> characters;

	private List<FavouriteItem> people;

	private List<FavouriteItem> mangakas;

	private List<FavouriteItem> seyu;

	private List<FavouriteItem> producers;

	private Favourites() {

	}

	public List<FavouriteItem> getAnimes() {
		return animes;
	}

	public List<FavouriteItem> getMangas() {
		return mangas;
	}

	public List<FavouriteItem> getCharacters() {
		return characters;
	}

	public List<FavouriteItem> getPeople() {
		return people;
	}

	public List<FavouriteItem> getMangakas() {
		return mangakas;
	}

	public List<FavouriteItem> getSeyu() {
		return seyu;
	}

	public List<FavouriteItem> getProducers() {
		return producers;
	}
}
