package net.pagala.JShikiApi.Usr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

/**
 * Created by firely-pasha on 7/19/17.
 */
@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class UserTypes {
	@JsonProperty("anime")
	private List<UserTitleTypes> animes;

	@JsonProperty("manga")
	private List<UserTitleTypes> mangas;


	private UserTypes() {

	}

	public List<UserTitleTypes> getAnimes() {
		return animes;
	}

	public List<UserTitleTypes> getMangas() {
		return mangas;
	}

	public static class UserTitleTypes {
		private String name;
		private String value;

		private UserTitleTypes() {

		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return value;
		}
	}
}
