package net.pagala.JShikiApi.Items;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public final class OAuthToken {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private int expiresIn;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("created_at")
    private Date createdAt;

    private OAuthToken() {

    }

    /**
     * @return Access token.
     */
    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    /**
     * @return Time when access token expires
     */
    public int getExpiresIn() {
        return expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public Date getCreatedAt() {
        return new Date(createdAt.getTime() * 1000);
    }
}
