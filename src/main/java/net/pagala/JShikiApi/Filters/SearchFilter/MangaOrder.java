package net.pagala.JShikiApi.Filters.SearchFilter;

public enum MangaOrder {
    ID,
    RANKED,
    TYPE,
    POPULARITY,
    NAME,
    AIRED_ON,
    VOLUMES,
    CHAPTERS,
    STATUS,
    RANDOM,
    ;
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
