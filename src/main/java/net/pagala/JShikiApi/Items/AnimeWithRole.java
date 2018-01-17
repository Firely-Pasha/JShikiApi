package net.pagala.JShikiApi.Items;

public class AnimeWithRole extends Anime implements TitleWithRole {
    private String role;

    private AnimeWithRole() {

    }

    public String getRole() {
        return role;
    }
}
