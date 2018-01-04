package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.Character;
import net.pagala.JShikiApi.Items.CharacterFull;
import net.pagala.JShikiApi.Items.Role;

import java.util.ArrayList;
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

    public static List<Role> getPersons(List<Role> roleList) {
        List<Role> characterList = new ArrayList<>();

        roleList.forEach((role -> {
            if (role.getPerson() != null) {
                System.out.println(role.getPerson().getName());
                for (String roless : role.getRoles()) {
                    System.out.println("\t" + roless);
                }
                characterList.add(role);
            }
        }));

        return characterList;
    }

    public static List<net.pagala.JShikiApi.Items.Character> getPersons(List<Role> roleList, String... roleTypes) {
        List<net.pagala.JShikiApi.Items.Character> personList = new ArrayList<>();

        roleList.forEach((role -> {
            if (role.getPerson() != null) {
                for (String neededRoleType : roleTypes) {
                    for (String currentRoleType : role.getRoles()) {
                        if (neededRoleType.equals(currentRoleType)) {
                            personList.add(role.getPerson());
                        }
                    }
                }
            }
        }));

        return personList;
    }
    /*
    Roles:
        Original Creator
        Director
     */
}
