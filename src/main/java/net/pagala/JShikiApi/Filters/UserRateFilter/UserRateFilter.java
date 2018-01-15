package net.pagala.JShikiApi.Filters.UserRateFilter;

import net.pagala.JShikiApi.Items.TitleListStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserRateFilter {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("target_id")
    private Integer targetId;

    @JsonProperty("target_type")
    private TargetType targetType;

    private TitleListStatus status;

    private Integer page;

    private Integer limit;

    public UserRateFilter(int userId) {
        this.userId = userId;
    }

    public UserRateFilter(int targetId, TargetType targetType) {
        this.targetId = targetId;
        this.status = status;
    }

    public String build() {
        String sb = "?" +
                (userId == null ? "" : "&user_id=" + userId) +
                (targetId == null ? "" : "&target_id=" + targetId) +
                (targetType == null ? "" : "&target_type=" + targetType) +
                (status == null ? "" : "&status=" + status) +
                (page == null ? "" : "&page=" + page) +
                (limit == null ? "" : "&limit=" + limit);

        return sb;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }

    public TitleListStatus getStatus() {
        return status;
    }

    public void setStatus(TitleListStatus status) {
        this.status = status;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
