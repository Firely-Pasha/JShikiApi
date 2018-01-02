package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Achievement;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Achievements {

    private Achievements() {

    }

    public static List<Achievement> getList(int userId) {
        return getItemList("/achievements/?user_id=" + userId, Achievement[].class);
    }
}
