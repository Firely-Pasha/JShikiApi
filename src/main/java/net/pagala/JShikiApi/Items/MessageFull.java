package net.pagala.JShikiApi.Items;

public class MessageFull extends Message {
    private User from;
    private User to;

    private MessageFull() {

    }

    public User getFrom() {
        return from;
    }

    public User getTo() {
        return to;
    }
}
