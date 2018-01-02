package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Publisher;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Publishers {

    private Publishers() {

    }

    public static List<Publisher> getList() {
        return getItemList("/publishers", Publisher[].class);
    }
}
