package es.itg.flythings.dataspace.sdk.utils;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An utility class for handling JWT.
 */
public final class JwtUtil {

    private static final Logger log = Logger.getLogger("JwtUtil");

    private JwtUtil() {
    }

    /**
     * Extracts the {@code exp} claim from a JWT without verifying the signature. Safe for
     * client-side use — we trust the token we just received from our own server.
     *
     * @param jwt the jwt
     * @return the expiry {@link Instant}, or {@link Instant#MAX} if not present.
     */
    public static Instant extractExpiry(String jwt) {
        try {
            String payload = jwt.split("\\.")[1];
            String json = new String(
                Base64.getUrlDecoder().decode(payload),
                StandardCharsets.UTF_8
            );
            // Lightweight parse — avoids pulling in a full JSON library just for one field
            String expValue = extractJsonLong(json, "exp");
            if (expValue == null) {
                log.log(Level.WARNING,
                    "Could not extract expiry from JWT, token will not be refreshed");
                return Instant.MAX;
            }
            return Instant.ofEpochSecond(Long.parseLong(expValue));
        } catch (Exception e) {
            log.log(Level.WARNING,
                "Could not extract expiry from JWT, token will not be refreshed");
            return Instant.MAX;
        }
    }

    private static String extractJsonLong(String json, String key) {
        String search = "\"" + key + "\"";
        int keyIdx = json.indexOf(search);
        if (keyIdx == -1) {
            return null;
        }

        int colonIdx = json.indexOf(':', keyIdx + search.length());
        if (colonIdx == -1) {
            return null;
        }

        int start = colonIdx + 1;
        while (start < json.length() && json.charAt(start) == ' ') {
            start++;
        }

        int end = start;
        while (end < json.length() && Character.isDigit(json.charAt(end))) {
            end++;
        }

        return start == end ? null : json.substring(start, end);
    }
}
