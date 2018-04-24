package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 *
 * Created by firely-pasha on 7/18/17.
 */
@SuppressWarnings("unused")
public class ExternalLink {
    private int id;

    private String kind;

    private String url;

    private String source;

    @JsonProperty("entry_id")
    private int entryId;

    @JsonProperty("entry_type")
    private TargetType entryType;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("updated_at")
    private Date updatesAt;

    @JsonProperty("imported_at")
    private Date importedAt;

    private ExternalLink() {

    }

    public int getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getUrl() {
        return url;
    }

    public String getSource() {
        return source;
    }

    public int getEntryId() {
        return entryId;
    }

    public TargetType getEntryType() {
        return entryType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatesAt() {
        return updatesAt;
    }

    public Date getImportedAt() {
        return importedAt;
    }
}
