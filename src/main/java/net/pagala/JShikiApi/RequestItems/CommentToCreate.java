package net.pagala.JShikiApi.RequestItems;

import net.pagala.JShikiApi.Filters.CommentFilter.CommentableType;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@SuppressWarnings("unused")
public class CommentToCreate {
    private String body;

    @JsonProperty("commentable_id")
    private int commentableId;

    @JsonProperty("commentable_type")
    private CommentableType commentableType;

    @JsonProperty("is_offtopic")
    private Boolean isOfftopic;

    @JsonProperty("is_summary")
    private Boolean isSummary;

    //FIXME: API FIX: NO CLUB CONSTANT IN COMMENTABLE TYPE!!!
    public CommentToCreate(String body, int commentableId, CommentableType commentableType) {
        this.body = body;
        this.commentableId = commentableId;
        this.commentableType = commentableType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public Boolean getIsOfftopic() {
        return isOfftopic;
    }

    public void setIsOfftopic(Boolean offtopic) {
        isOfftopic = offtopic;
    }

    public Boolean getIsSummary() {
        return isSummary;
    }

    public void setIsSummary(Boolean summary) {
        isSummary = summary;
    }
}
