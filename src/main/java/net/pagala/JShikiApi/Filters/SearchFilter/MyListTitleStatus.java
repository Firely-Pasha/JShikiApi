package net.pagala.JShikiApi.Filters.SearchFilter;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
public enum  MyListTitleStatus {
    PLANNED,
    WATCHING,
    REWATCHING,
    COMPLETED,
    ON_HOLD,
    DROPPED,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
