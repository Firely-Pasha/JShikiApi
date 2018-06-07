package net.pagala.JShikiApi.Items;

/**
 *
 * Created by firely-pasha on 7/18/17.
 */
@SuppressWarnings("unused")
public class Link {
    //TODO: Replace strings with constants.
    private int source;

    private int target;

    private int weight;

    private String relation;


    private Link() {

    }

    public int getSource() {
        return source;
    }

    public int getTarget() {
        return target;
    }

    public int getWeight() {
        return weight;
    }

    public String getRelation() {
        return relation;
    }
}
