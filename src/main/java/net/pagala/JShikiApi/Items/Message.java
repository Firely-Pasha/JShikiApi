package net.pagala.JShikiApi.Items;

public class Message extends ShortMessage {
	private User from;
	private User to;

	private Message() {

	}

	public User getFrom() {
		return from;
	}

	public User getTo() {
		return to;
	}
}
