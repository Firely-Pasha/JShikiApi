package net.pagala.JShikiApi.Items;

import net.pagala.JShikiApi.Core.Shikimori;
import net.pagala.JShikiApi.Filters.UserRateFilter.TargetType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Date;

public class UserRate extends TitleUserRate {
    @JsonProperty("target_id")
    private int targetId;

    @JsonProperty("target_type")
    private TargetType targetType;

    @JsonProperty("user_id")
    private int userId;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatedAt;

    private UserRate() {

    }

    public int getTargetId() {
        return targetId;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public int getUserId() {
        return userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    @JsonIgnore
    @Override
    public String toString() {
        try {
            return Shikimori.getObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
