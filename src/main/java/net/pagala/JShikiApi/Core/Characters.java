package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Character;
import net.pagala.JShikiApi.Items.CharacterFull;
import net.pagala.JShikiApi.Items.Role;

import java.util.ArrayList;
import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class Characters {

    private Characters() {

    }

    public static CharacterFull get(int id) {
        return getItem("/characters/" + id, CharacterFull.class);
    }

    public static List<Character> getList(String searchString) {
        return getItemList("/characters/search?search=" + searchString, Character[].class);
    }

    public static List<net.pagala.JShikiApi.Items.Character> getCharacters(List<Role> roles) {
        List<net.pagala.JShikiApi.Items.Character> characterList = new ArrayList<>();

        roles.forEach((role -> {
            if (role.getCharacter() != null) {
                characterList.add(role.getCharacter());
            }
        }));

        return characterList;
    }

    public static List<net.pagala.JShikiApi.Items.Character> getMainCharacters(List<Role> roleList) {
        List<net.pagala.JShikiApi.Items.Character> mainCharacters = new ArrayList<>();

        roleList.forEach((role -> {
            if (role.getCharacter() != null) {
                if (role.getRoles()[0].equals("Main")) {
                    mainCharacters.add(role.getCharacter());
                }
            }
        }));

        return mainCharacters;
    }

    public static List<net.pagala.JShikiApi.Items.Character> getSupportingCharacters(List<Role> roleList) {
        List<net.pagala.JShikiApi.Items.Character> mainCharacters = new ArrayList<>();

        roleList.forEach((role -> {
            if (role.getCharacter() != null) {
                if (role.getRoles()[0].equals("Supporting")) {
                    mainCharacters.add(role.getCharacter());
                }
            }
        }));

        return mainCharacters;
    }
}
