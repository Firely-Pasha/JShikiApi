package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Character;
import net.pagala.JShikiApi.Items.ClubLogo;
import net.pagala.JShikiApi.Items.Image;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@SuppressWarnings("unused")
public class Club {

	private int id;

	private String name;

	private ClubLogo logo;

	@JsonProperty("is_censored")
	private boolean isCensored;

	@JsonProperty("join_policy")
	private String joinPolicy;

	@JsonProperty("comment_policy")
	private String commentPolicy;


	protected Club() {

	}

	private List<Anime> getAnimes() {
		return Shikimori.getItemList("/clubs/" + getId() + "/animes", Anime[].class);
	}

	private List<Manga> getMangas() {
		return Shikimori.getItemList("/clubs/" + getId() + "/mangas", Manga[].class);
	}

	//TODO: No such property.
	private List<Manga> getRanobe() {
		return Shikimori.getItemList("/clubs/" + getId() + "/ranobe", Manga[].class);
	}

	private List<Character> getCharacters() {
		return Shikimori.getItemList("/clubs/" + getId() + "/characters", Character[].class);
	}

	//TODO: Implement limit and page for this.
	private List<User> getMembers() {
		return Shikimori.getItemList("/clubs/" + getId() + "/members", User[].class);
	}

	private List<Image> getImages() {
		return Shikimori.getItemList("/clubs/" + getId() + "/images", Image[].class);
	}

	//TODO: Check for double join.
	public void join() {
		Shikimori.postRequest("/clubs/" + getId() + "/join", null, false);
	}

	//TODO: Check for double leave.
	public void leave() {
		Shikimori.postRequest("/clubs/" + getId() + "/leave", null, false);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ClubLogo getLogo() {
		return logo;
	}

	public boolean isCensored() {
		return isCensored;
	}

	public String getJoinPolicy() {
		return joinPolicy;
	}

	public String getCommentPolicy() {
		return commentPolicy;
	}
}
