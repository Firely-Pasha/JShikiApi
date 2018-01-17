package net.pagala.JShikiApi.Items;

public abstract class Unit {

    private int id;

    private String name;

    private String russian;

    private Image image;

    private String url;

    protected Unit() {

    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRussian() {
        return russian;
    }

    public Image getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }
}
