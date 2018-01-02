package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Character;
import net.pagala.JShikiApi.Items.CharacterFull;

import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class People {

    public static CharacterFull get(int id) {
        return getItem("/people/" + id, CharacterFull.class);
    }

    public static List<Character> getList(String searchString) {
        return getItemList("/people/search?search=" + searchString, Character[].class);
    }
}
