package net.pagala.JShikiApi.Core;

import net.pagala.JShikiApi.Filters.CommentFilter.CommentFilter;
import net.pagala.JShikiApi.Items.CommentFull;
import net.pagala.JShikiApi.Items.Notice;
import net.pagala.JShikiApi.RequestItems.CommentToCreate;

import static net.pagala.JShikiApi.Core.Shikimori.*;

public final class Comments {

    private Comments() {

    }

    public static ApiCall<CommentFull> get(int commentId) {
        return getItem("/comments/" + commentId, CommentFull.class);
    }


    public static ApiCall<CommentFull[]> getList(CommentFilter filter) {
        return getItem("/comments?" + filter.build(), CommentFull[].class);
    }

    public static ApiCall<CommentFull> create(CommentToCreate comment, boolean broadcast) {
        return postItem("/comments", new CommentToCreateInternal(broadcast, comment), CommentFull.class);
    }

    public static ApiCall<CommentFull> update(int commentId, String body) {
        return putItem("/comments/" + commentId, new CommentToUpdateInternal(body), CommentFull.class);
    }

    public static ApiCall<Notice> delete(int commentId) {
        return deleteItem("/comments/" + commentId, Notice.class);
    }

    private static class CommentToCreateInternal {
        private boolean broadcast;
        private boolean frontend;
        private CommentToCreate comment;

        private CommentToCreateInternal(boolean broadcast, CommentToCreate comment) {
            this.broadcast = broadcast;
            this.frontend = false;
            this.comment = comment;
        }

        public boolean isBroadcast() {
            return broadcast;
        }

        public boolean isFrontend() {
            return frontend;
        }

        public CommentToCreate getComment() {
            return comment;
        }
    }

    private static class CommentToUpdateInternal {
        private final boolean frontend;
        private final Comment comment;

        private CommentToUpdateInternal(String comment) {
            this.frontend = false;
            this.comment = new Comment(comment);
        }

        public boolean isFrontend() {
            return frontend;
        }

        public Comment getComment() {
            return comment;
        }

        private class Comment {
            private final String body;

            private Comment(String body) {
                this.body = body;
            }

            public String getBody() {
                return body;
            }
        }
    }
}