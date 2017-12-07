package net.pagala.JShikiApi.Usr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

/**
 *
 * Created by firely-pasha on 7/19/17.
 */
@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRatings {
	@JsonProperty("anime")
	private List<UserTitleRating> animes;

	private UserRatings() {

	}

	public List<UserTitleRating> getAnimes() {
		return animes;
	}

	public static class UserTitleRating {
		private String name;
		private int value;

		private UserTitleRating() {

		}

		public String getName() {
			return name;
		}

		public int getValue() {
			return value;
		}
	}
}
