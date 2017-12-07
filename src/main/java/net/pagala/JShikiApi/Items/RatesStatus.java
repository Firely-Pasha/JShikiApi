package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class RatesStatus {
    private String name;

    private int value;


    private RatesStatus() {

    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}
