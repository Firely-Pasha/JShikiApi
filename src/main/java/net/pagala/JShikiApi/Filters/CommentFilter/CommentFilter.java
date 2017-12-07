package net.pagala.JShikiApi.Filters.CommentFilter;

@SuppressWarnings("unused")
public class CommentFilter {
    private int commentableId;

    private CommentableType commentableType;

    private Integer page;

    private Integer limit;

    private Integer desc;

    public CommentFilter(int commentableId, CommentableType commentableType) {
        this.commentableId = commentableId;
        this.commentableType = commentableType;
    }

    public CommentFilter(int commentableId, CommentableType commentableType, int limit) {
        this.commentableId = commentableId;
        this.commentableType = commentableType;
        this.limit = limit;
    }

    public String build() {
        return "commentable_id=" + commentableId +
                "&commentable_type=" + commentableType +
                (page == null ? "" : "&page=" + page) +
                (limit == null ? "" : "&limit=" + limit) +
                (desc == null ? "" : "&desc=" + desc)
                ;
    }

    public int getCommentableId() {
        return commentableId;
    }

    public void setCommentableId(int commentableId) {
        this.commentableId = commentableId;
    }

    public CommentableType getCommentableType() {
        return commentableType;
    }

    public void setCommentableType(CommentableType commentableType) {
        this.commentableType = commentableType;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getDesc() {
        return desc;
    }

    public void setDesc(boolean desc) {
        this.desc = desc ? 1 : 0;
    }
}
