package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.CalendarItem;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Calendar {

    private Calendar() {

    }

    public static ApiCall<CalendarItem[]> get() {
        return getItem("/calendar/", CalendarItem[].class);
    }
}
