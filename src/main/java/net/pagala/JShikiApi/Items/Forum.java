package net.pagala.JShikiApi.Items;

@SuppressWarnings("unused")
public class Forum {
    private int id;

    private int position;

    private String name;

    private Forums permalink;

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

    public Forums getPermalink() {
        return permalink;
    }

    public String getUrl() {
        return url;
    }
}
