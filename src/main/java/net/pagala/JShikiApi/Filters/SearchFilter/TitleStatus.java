package net.pagala.JShikiApi.Filters.SearchFilter;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
public enum  TitleStatus {
    ANONS,
    ONGOING,
    RELEASED,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
