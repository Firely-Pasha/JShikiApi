package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Genre;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Genres {

    private Genres() {

    }

    public static ApiCall<Genre[]> getList() {
        return getItem("/genres", Genre[].class);
    }
}
