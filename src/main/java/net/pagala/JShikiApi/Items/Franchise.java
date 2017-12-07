package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by firely-pasha on 7/18/17.
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Franchise {
    private List<Link> links;

    private List<Node> nodes;

    private Franchise() {

    }

    public List<Link> getLinks() {
        return links;
    }

    public List<Node> getNodes() {
        return nodes;
    }
}
