package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Ban;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Bans {

    private Bans() {

    }

    public static List<Ban> getList(int limit, int page) {
        return getItemList("/bans?&limit=" + limit + "&page=" + page, Ban[].class);
    }
}
