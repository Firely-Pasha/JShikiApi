package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Forum;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Forums {

    private Forums() {
//        throw new AssertionError();
    }

    public static ApiCall<Forum[]> getList() {
        return getItem("/forums", Forum[].class);
    }
}
