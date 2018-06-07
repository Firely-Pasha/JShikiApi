package net.pagala.JShikiApi.Core;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Stats {

    private Stats() {

    }

    public static ApiCall<Integer[]> getActiveUsers() {
        return getItem("/stats/active_users", Integer[].class);
    }
}