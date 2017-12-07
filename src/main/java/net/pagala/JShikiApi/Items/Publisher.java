package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/17/17.
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Publisher {
    private int id;

    private String name;


    private Publisher() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
