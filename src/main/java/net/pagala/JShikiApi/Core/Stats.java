package net.pagala.JShikiApi.Core;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public class Stats {
    private Stats() {

    }

    public static List<Integer> getActiveUsers() {
        return getItemList("/stats/active_users", Integer[].class);
    }
}