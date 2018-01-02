package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Forum;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Forums {

    private Forums() {
//        throw new AssertionError();
    }

    public static List<Forum> getList() {
        return getItemList("/forums", Forum[].class);
    }
}
