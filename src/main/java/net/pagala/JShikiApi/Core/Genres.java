package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Genre;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Genres {

    private Genres() {

    }

    public static List<Genre> getList() {
        return getItemList("/genres", Genre[].class);
    }
}
