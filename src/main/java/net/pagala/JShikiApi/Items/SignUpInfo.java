package net.pagala.JShikiApi.Items;

public final class SignUpInfo {
    private UserShort user;
    private OAuthToken oauthToken;

    private SignUpInfo() {

    }

    public UserShort getUser() {
        return user;
    }

    public OAuthToken getOauthToken() {
        return oauthToken;
    }
}
