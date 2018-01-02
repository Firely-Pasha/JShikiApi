package net.pagala.JShikiApi.Items;

import net.pagala.JShikiApi.Items.Anime;
import net.pagala.JShikiApi.Items.TitleUserRate;
import net.pagala.JShikiApi.Items.Manga;
import net.pagala.JShikiApi.Items.User;

@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class AnimeRate extends TitleUserRate {
	private User user;

	private Anime anime;

	private Manga manga;

	private AnimeRate() {

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
