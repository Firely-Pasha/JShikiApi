package net.pagala.JShikiApi.Items;

import net.pagala.JShikiApi.Items.Character;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/13/17.
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Role {
    private String[] roles;

    @JsonProperty("roles_russian")
    private String[] rolesRussian;

    private Character character;

    private Character person;


    private Role() {

    }

    public String[] getRoles() {
        return roles;
    }

    public String[] getRolesRussian() {
        return rolesRussian;
    }

    public Character getCharacter() {
        return character;
    }

    public Character getPerson() {
        return person;
    }
}
