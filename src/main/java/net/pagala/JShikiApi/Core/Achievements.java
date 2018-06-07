package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Achievement;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Achievements {

    private Achievements() {

    }

    public static ApiCall<Achievement[]> getList(int userId) {
        return getItem("/achievements/?user_id=" + userId, Achievement[].class);
    }
}
