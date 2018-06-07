package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Character;
import net.pagala.JShikiApi.Items.CharacterFull;
import net.pagala.JShikiApi.Items.Role;

import java.util.ArrayList;
import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class Characters {

    private Characters() {

    }

    public static ApiCall<CharacterFull> get(int id) {
        return getItem("/characters/" + id, CharacterFull.class);
    }

    public static ApiCall<Character[]> getList(String searchString) {
        return getItem("/characters/search?search=" + searchString, Character[].class);
    }

    public static List<Character> getCharacters(Role[] roles) {
        List<Character> characterList = new ArrayList<>();
        for (Role role : roles) {
            if (role.getCharacter() != null) {
                characterList.add(role.getCharacter());
            }
        }
        return characterList;
    }

    public static List<Character> getMainCharacters(Role[] roleList) {
        List<Character> mainCharacters = new ArrayList<>();
        for (Role role : roleList) {
            if (role.getCharacter() != null) {
                if (role.getRoles()[0].equals("Main")) {
                    mainCharacters.add(role.getCharacter());
                }
            }
        }
        return mainCharacters;
    }

    public static List<Character> getSupportingCharacters(Role[] roleList) {
        List<Character> mainCharacters = new ArrayList<>();
        for (Role role : roleList) {
            if (role.getCharacter() != null) {
                if (role.getRoles()[0].equals("Supporting")) {
                    mainCharacters.add(role.getCharacter());
                }
            }
        }
        return mainCharacters;
    }
}
