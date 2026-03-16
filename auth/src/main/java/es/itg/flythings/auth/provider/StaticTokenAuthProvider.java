package es.itg.flythings.auth.provider;

final class StaticTokenAuthProvider implements AuthProvider {

    private final String token;

    StaticTokenAuthProvider(String token) {
        if (token == null || token.isBlank()) {
            throw new IllegalArgumentException("Token must not be null or blank");
        }
        this.token = token;
    }

    @Override
    public String getToken() {
        return token;
    }
}
