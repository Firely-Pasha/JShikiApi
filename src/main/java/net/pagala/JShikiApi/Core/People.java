package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Items.*;

import java.util.ArrayList;
import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;

public final class People {

    public static ApiCall<PersonFull> get(int id) {
        return getItem("/people/" + id, PersonFull.class);
    }

    public static ApiCall<Person[]> getList(String searchString) {
        return getItem("/people/search?search=" + searchString, Person[].class);
    }

    public static List<Role> getPersons(Role[] roleList) {
        List<Role> characterList = new ArrayList<>();
        for (Role role : roleList) {
            if (role.getPerson() != null) {
                characterList.add(role);
            }
        }
        return characterList;
    }

    public static List<Role> getPersons(Role[] roleList, String... roleTypes) {
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
