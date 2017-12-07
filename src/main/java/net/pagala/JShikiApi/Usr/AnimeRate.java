package net.pagala.JShikiApi.Usr;

import net.pagala.JShikiApi.Core.Anime;
import net.pagala.JShikiApi.Items.TitleUserRate;
import net.pagala.JShikiApi.Core.Manga;
import net.pagala.JShikiApi.Core.User;

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
