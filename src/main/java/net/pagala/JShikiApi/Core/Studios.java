package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Studio;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Studios {

    private Studios() {

    }

    public static List<Studio> getStudios() {
        return getItemList("/studios", Studio[].class);
    }
}
