package net.pagala.JShikiApi.Filters.SearchFilter;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
public enum  AnimeType {
    TV,
    MOVIE,
    OVA,
    ONA,
    SPECIAL,
    MUSIC,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
