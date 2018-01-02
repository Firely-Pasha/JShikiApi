package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.CalendarItem;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Calendar {

    private Calendar() {

    }

    public static List<CalendarItem> get() {
        return getItemList("/calendar/", CalendarItem[].class);
    }
}
