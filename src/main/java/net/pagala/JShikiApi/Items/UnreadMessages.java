package net.pagala.JShikiApi.Items;

@SuppressWarnings("unused")
public class UnreadMessages {
    private int messages;

    private int news;

    private int notifications;


    private UnreadMessages() {

    }

    public int getMessages() {
        return messages;
    }

    public int getNews() {
        return news;
    }

    public int getNotifications() {
        return notifications;
    }
}
