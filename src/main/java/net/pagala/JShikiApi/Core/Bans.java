package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Ban;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Bans {

    private Bans() {

    }

    public static ApiCall<Ban[]> getList(int limit, int page) {
        return getItem("/bans?&limit=" + limit + "&page=" + page, Ban[].class);
    }
}
