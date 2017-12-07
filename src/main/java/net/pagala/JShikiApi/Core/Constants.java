package net.pagala.JShikiApi.Core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

import static net.pagala.JShikiApi.Core.Shikimori.getItem;
import static net.pagala.JShikiApi.Core.Shikimori.getItemList;

public class Constants {
    private Constants() {

    }

    public static Title getAnime() {
        return getItem("/constants/anime", Title.class);
    }


    public static Title getManga() {
        return getItem("/constants/manga", Title.class);
    }

    public static UserRate getUserRate() {
        return getItem("/constants/user_rate", UserRate.class);
    }

    public static Club getClub() {
        return getItem("/constants/club", Club.class);
    }

    public static List<Smile> getSmiles() {
        return getItemList("/constants/smileys", Smile[].class);
    }

    public static class Title {
        private List<String> kind;

        private List<String> status;

        private Title() {

        }

        public List<String> getKind() {
            return kind;
        }

        public List<String> getStatus() {
            return status;
        }
    }

    public static class UserRate {
        private List<String> status;

        private UserRate() {

        }

        public List<String> getStatus() {
            return status;
        }
    }

    public static class Club {
        @JsonProperty("join_policy")
        private List<String> joinPolicy;

        @JsonProperty("comment_policy")
        private List<String> commentPolicy;

        @JsonProperty("image_upload_policy")
        private List<String> imageUploadPolicy;

        private Club() {

        }

        public List<String> getJoinPolicy() {
            return joinPolicy;
        }

        public List<String> getCommentPolicy() {
            return commentPolicy;
        }

        public List<String> getImageUploadPolicy() {
            return imageUploadPolicy;
        }
    }

    public static class Smile {
        private String bbcode;

        private String path;

        private Smile() {

        }

        public String getBbcode() {
            return bbcode;
        }

        public String getPath() {
            return path;
        }
    }
}