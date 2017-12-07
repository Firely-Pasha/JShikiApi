package net.pagala.JShikiApi.Filters.SearchFilter;

/**
 *
 * Created by firely-pasha on 7/12/17.
 */
public enum AnimeOrder {
    ID,
    RANKED,
    TYPE,
    POPULARITY,
    NAME,
    AIRED_ON,
    EPISODES,
    STATUS,
    RANDOM,
    ;
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
