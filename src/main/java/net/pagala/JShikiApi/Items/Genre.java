package net.pagala.JShikiApi.Items;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
@SuppressWarnings("unused")
public class Genre {
    private int id;

    private String name;

    private String russian;

    private String kind;


    private Genre() {

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

    public String getKind() {
        return kind;
    }
}
