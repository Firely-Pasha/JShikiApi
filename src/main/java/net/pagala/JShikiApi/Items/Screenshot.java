package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
@SuppressWarnings("unused")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Screenshot {
    private String original;

    private String preview;

    private Screenshot() {

    }

    public String getOriginal() {
        return original;
    }

    public String getPreview() {
        return preview;
    }
}