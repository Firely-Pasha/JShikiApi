package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * Created by firely-pasha on 7/18/17.
 */
@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalLink {
    private int id;

    private String kind;

    private String url;

    private String source;

    @JsonProperty("entry_id")
    private int entryId;

    @JsonProperty("entry_type")
    private String entryType;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatesAt;

    @JsonProperty("imported_at")
    private String importedAt;

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

    public String getEntryType() {
        return entryType;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatesAt() {
        return updatesAt;
    }

    public String getImportedAt() {
        return importedAt;
    }
}
