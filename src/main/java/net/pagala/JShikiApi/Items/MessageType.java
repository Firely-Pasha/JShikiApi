package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public enum MessageType {
	@JsonProperty("inbox")
	INBOX,
	@JsonProperty("private")
	PRIVATE,
	@JsonProperty("sent")
	SENT,
	@JsonProperty("news")
	NEWS,
	@JsonProperty("notifications")
	NOTIFICATIONS,
	;

	@Override
	public String toString() {
		return name().toLowerCase();
	}
}
