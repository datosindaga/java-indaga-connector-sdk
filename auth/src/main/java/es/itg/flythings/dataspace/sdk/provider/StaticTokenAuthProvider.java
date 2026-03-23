package es.itg.flythings.dataspace.sdk.provider;

/**
 * The static token auth provider. It will use the given token on the following request made, beware
 * the token may expire.
 */
record StaticTokenAuthProvider(String token) implements AuthProvider {

    /**
     * Instantiates a new static token auth provider.
     *
     * @param token the token
     */
    StaticTokenAuthProvider {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("Token must not be null or blank");
        }
    }
}
