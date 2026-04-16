package es.itg.flythings.dataspace.sdk.provider;

import es.itg.flythings.dataspace.sdk.client.LoginClient;
import es.itg.flythings.dataspace.sdk.dto.TokenResponse;
import es.itg.flythings.dataspace.sdk.exceptions.SdkErrorDecoder;
import es.itg.flythings.dataspace.sdk.utils.JwtUtil;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The Credentials auth provider. Requests and refreshes the token automatically
 */
final class CredentialsAuthProvider implements AuthProvider {

    private static final long EXPIRY_BUFFER_SECONDS = 30;

    private final String base64Credentials;
    private final LoginClient loginClient;
    private final ReentrantLock refreshLock = new ReentrantLock();
    private volatile String cachedToken;
    private volatile Instant expiresAt = Instant.MIN;

    /**
     * Instantiates a new Credentials auth provider.
     *
     * @param baseUrl  the base url
     * @param username the username
     * @param password the password
     */
    CredentialsAuthProvider(String baseUrl, String username, String password) {
        this.base64Credentials = Base64.getEncoder().encodeToString(
            (username + ":" + password).getBytes(StandardCharsets.UTF_8)
        );
        this.loginClient = Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .errorDecoder(new SdkErrorDecoder())
            .target(LoginClient.class, baseUrl);
    }

    @Override
    public String token() {
        return isTokenValid() ? cachedToken : refreshToken();
    }

    private boolean isTokenValid() {
        return cachedToken != null
            && Instant.now().isBefore(expiresAt.minusSeconds(EXPIRY_BUFFER_SECONDS));
    }

    private String refreshToken() {
        refreshLock.lock();
        try {
            if (isTokenValid()) {
                return cachedToken;
            }

            TokenResponse res = loginClient.login(base64Credentials);
            cachedToken = res.getToken();
            expiresAt = JwtUtil.extractExpiry(cachedToken);

            return cachedToken;
        } finally {
            refreshLock.unlock();
        }
    }
}



