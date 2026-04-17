package es.itg.flythings.dataspace.sdk.provider;

/**
 * The interface Auth provider. Allows for authentication via token or credentials
 */
public interface AuthProvider {

    /**
     * Use token auth provider.
     *
     * @param token the token
     * @return the auth provider
     */
    static AuthProvider ofToken(String token) {
        return new StaticTokenAuthProvider(token);
    }

    /**
     * Use credentials auth provider.
     *
     * @param baseUrl  the base url
     * @param username the username/identifier/email
     * @param password the password
     * @return the auth provider
     */
    static AuthProvider ofCredentials(String baseUrl, String username, String password) {
        return new CredentialsAuthProvider(baseUrl, username, password);
    }

    /**
     * Returns a valid Bearer token. Implementations handle caching and refresh internally — callers
     * just ask for a token.
     *
     * @return raw token value (without the "Bearer " prefix)
     */
    String token();
}

