package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {
    private String original;

    private String preview;

    private String x96;

    private String x48;


    private Image() {

    }

    public String getOriginal() {
        return original;
    }

    public String getPreview() {
        return preview;
    }

    public String getX96() {
        return x96;
    }

    public String getX48() {
        return x48;
    }
}
