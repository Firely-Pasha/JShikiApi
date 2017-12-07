package net.pagala.JShikiApi.Filters.SearchFilter;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
public enum Season {
    SUMMER,
    WINTER,
    SPRING,
    FALL,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
