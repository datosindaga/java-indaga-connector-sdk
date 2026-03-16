package es.itg.flythings.auth.provider;

public interface AuthProvider {

    static AuthProvider ofToken(String token) {
        return new StaticTokenAuthProvider(token);
    }

    static AuthProvider ofCredentials(String baseUrl, String username, String password) {
        return new CredentialsAuthProvider(baseUrl, username, password);
    }

    /**
     * Returns a valid Bearer token. Implementations handle caching and refresh internally — callers
     * just ask for a token.
     *
     * @return raw token value (without the "Bearer " prefix)
     */
    String getToken();
}

