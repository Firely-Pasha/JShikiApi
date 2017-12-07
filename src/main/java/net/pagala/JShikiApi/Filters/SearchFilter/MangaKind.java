package net.pagala.JShikiApi.Filters.SearchFilter;

public enum MangaKind {
    MANGA,
    MANHWA,
    MANHUA,
    NOVEL,
    ONE_SHOT,
    DOUJIN,
    ;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
