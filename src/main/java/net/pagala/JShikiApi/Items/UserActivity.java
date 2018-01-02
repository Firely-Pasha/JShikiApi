package net.pagala.JShikiApi.Items;

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
public class UserActivity {
	private List<Integer> name;
	private int value;

	private UserActivity() {

	}

	public List<Integer> getName() {
		return name;
	}

	public int getValue() {
		return value;
	}
}
