package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
@SuppressWarnings("unused")
public class Studio {
    private int id;

    private String name;

    @JsonProperty("filtered_name")
    private String filteredName;

    private boolean real;

    private String image;


    private Studio() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFilteredName() {
        return filteredName;
    }

    public boolean isReal() {
        return real;
    }

    public String getImage() {
        return image;
    }
}
