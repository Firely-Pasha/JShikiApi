package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.*;
import net.pagala.JShikiApi.Items.Character;

import java.util.ArrayList;
import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public final class People {

    public static PersonFull get(int id) {
        return getItem("/people/" + id, PersonFull.class);
    }

    public static List<Person> getList(String searchString) {
        return getItemList("/people/search?search=" + searchString, Person[].class);
    }

    public static List<Role> getPersons(List<Role> roleList) {
        List<Role> characterList = new ArrayList<>();
        for (Role role : roleList) {
            if (role.getPerson() != null) {
                characterList.add(role);
            }
        }
        return characterList;
    }

    public static List<Role> getPersons(List<Role> roleList, String... roleTypes) {
        List<Role> personList = new ArrayList<>();
        for (Role role : roleList) {
            if (role.getPerson() != null) {
                exit: for (String neededRoleType : roleTypes) {
                    for (String currentRoleType : role.getRoles()) {
                        if (neededRoleType.equals(currentRoleType)) {
                            personList.add(role);
                            break exit;
                        }
                    }
                }
            }
        }
        return personList;
    }
    /*
    Roles:
        Original Creator
        Director
     */
}
