package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Publisher;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Publishers {

    private Publishers() {

    }

    public static ApiCall<Publisher[]> getList() {
        return getItem("/publishers", Publisher[].class);
    }
}
