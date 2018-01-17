package net.pagala.JShikiApi.Items;

public class MangaWithRole extends Manga implements TitleWithRole {
    private String role;

    private MangaWithRole() {

    }

    public String getRole() {
        return role;
    }
}
