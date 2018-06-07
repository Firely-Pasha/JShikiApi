package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Studio;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Studios {

    private Studios() {

    }

    public static ApiCall<Studio[]> getList() {
        return getItem("/studios", Studio[].class);
    }
}
