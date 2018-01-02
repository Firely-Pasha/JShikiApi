package net.pagala.JShikiApi.Items;

@SuppressWarnings("unused")
public class Forum {
    private int id;

    private int position;

    private String name;

    private ForumTypes permalink;

    private String url;

    private Forum() {

    }

    public int getId() {
        return id;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public ForumTypes getPermalink() {
        return permalink;
    }

    public String getUrl() {
        return url;
    }
}
