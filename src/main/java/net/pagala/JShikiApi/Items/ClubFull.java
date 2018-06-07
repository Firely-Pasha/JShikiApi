package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
public class ClubFull extends Club{

    @JsonProperty("comment_policy")
    private String commentPolicy;

    private String description;

    @JsonProperty("description_html")
    private String descriptionHtml;

    private Manga[] mangas;

    private Character[] characters;

    @JsonProperty("thread_id")
    private int threadId;

    @JsonProperty("topic_id")
    private int topicId;

    @JsonProperty("user_role")
    private String userRole;

    @JsonProperty("style_id")
    private int styleId;

    //TODO: Mb remove this?
    private User[] members;

    private Anime[] animes;

    private ClubsImage[] images;

    private ClubFull() {

    }

    public String getCommentPolicy() {
        return commentPolicy;
    }

    public String getDescription() {
        return description;
    }

    public String getDescriptionHtml() {
        return descriptionHtml;
    }

    public Manga[] getMangas() {
        return mangas;
    }

    public Character[] getCharacters() {
        return characters;
    }

    public int getThreadId() {
        return threadId;
    }

    public int getTopicId() {
        return topicId;
    }

    public String getUserRole() {
        return userRole;
    }

    public int getStyleId() {
        return styleId;
    }

    public User[] getMembers() {
        return members;
    }

    public Anime[] getAnimes() {
        return animes;
    }

    public ClubsImage[] getImages() {
        return images;
    }
}
