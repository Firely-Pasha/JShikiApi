package net.pagala.JShikiApi.Filters.SearchFilter;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
public enum TitleRating {
    NONE,
    G,
    PG,
    PG_13,
    R,
    R_PLUS,
    RX,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}