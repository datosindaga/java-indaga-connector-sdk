package es.itg.flythings.dataspace.sdk.config;

import es.itg.flythings.dataspace.sdk.exceptions.SdkErrorDecoder;
import es.itg.flythings.dataspace.sdk.provider.AuthProvider;
import feign.Feign;
import feign.Logger.Level;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Single source of truth for all SDK configuration.
 *
 * <p>Usage — static token:
 * <pre>{@code
 * SdkConfig config = SdkConfig.builder()
 *         .apiUrl("https://api.example.com")
 *         .token("eyJhbGci...")
 *         .build();
 * }*</pre>
 *
 * <p>Usage — user/password:
 * <pre>{@code
 * SdkConfig config = SdkConfig.builder()
 *         .apiUrl("https://api.example.com")
 *         .authApiUrl("https://auth.example.com")
 *         .credentials("user@example.com", "s3cr3t")
 *         .build();
 * }*</pre>
 *
 * <p>Then build any client:
 * <pre>{@code
 * LoginClient login = config.buildClient(LoginClient.class);
 * }*</pre>
 */
public final class SdkConfig {

    private final String apiUrl;
    private final AuthProvider authProvider;
    private final boolean debug;
    private final Level level;

    private SdkConfig(String apiUrl, AuthProvider authProvider, boolean debug, Level level) {
        this.apiUrl = apiUrl;
        this.authProvider = authProvider;
        this.debug = debug;
        this.level = level;
    }

    /**
     * Return a SDK Config Builder.
     *
     * @return the builder
     */
    public static Builder builder() {
        return new Builder();
    }

    // ------------------------------------------------------------------ //

    /**
     * Builds a Feign client for the given interface, pointed at the API URL with authentication
     * already wired in.
     *
     * @param <T>         the type parameter
     * @param clientClass the client class
     * @return the t
     */
    public <T> T buildClient(Class<T> clientClass) {
        var client = Feign.builder()
            .encoder(new JacksonEncoder())
            .decoder(new JacksonDecoder())
            .errorDecoder(new SdkErrorDecoder())
            .requestInterceptor(new BearerAuthInterceptor(authProvider));

        if (debug) {
            client.logger(new feign.Logger.JavaLogger(clientClass.getName()))
                .logLevel(level);
        }

        return client.target(clientClass, apiUrl);
    }

    /**
     * Instantiates a service by invoking its {@code (SdkConfig)} constructor.
     *
     * <p>Usage:
     * <pre>{@code
     * EdrService edr = config.buildService(EdrService.class);
     * }</pre>
     *
     * @param <T>          the service type
     * @param serviceClass a class that implements {@link SdkService} and has a public
     *                     {@code (SdkConfig)} constructor
     * @return the instantiated service
     * @throws IllegalArgumentException if the constructor is missing or instantiation fails
     */
    public <T extends SdkService> T buildService(Class<T> serviceClass) {
        try {
            Constructor<T> ctor = serviceClass.getConstructor(SdkConfig.class);
            return ctor.newInstance(this);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(
                serviceClass.getSimpleName() + " must have a public (SdkConfig) constructor", e
            );
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException(
                "Failed to instantiate " + serviceClass.getSimpleName(), e.getCause()
            );
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException(
                "Cannot instantiate " + serviceClass.getSimpleName(), e
            );
        }
    }

    /**
     * The Builder to configure the SDKConfig.
     */
    public static final class Builder {

        private String apiUrl;
        private String authApiUrl;
        private String username;
        private String password;
        private String token;
        private boolean debug;
        private Level level;

        private Builder() {
        }

        private static void requireSet(String value, String message) {
            if (!isSet(value)) {
                throw new IllegalStateException(message);
            }
        }

        private static boolean isSet(String value) {
            return value != null && !value.isBlank();
        }

        /**
         * Base URL of the main API (required).
         *
         * @param apiUrl the api url
         * @return the builder
         */
        public Builder apiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
            return this;
        }

        /**
         * Base URL of the auth/login API (required when using credentials).
         *
         * @param authApiUrl the auth api url
         * @return the builder
         */
        public Builder authApiUrl(String authApiUrl) {
            this.authApiUrl = authApiUrl;
            return this;
        }

        /**
         * Mutually exclusive with {@link #token}.
         *
         * @param username the username
         * @param password the password
         * @return the builder
         */
        public Builder credentials(String username, String password) {
            this.username = username;
            this.password = password;
            return this;
        }

        /**
         * Mutually exclusive with {@link #credentials}.
         *
         * @param token the token
         * @return the builder
         */
        public Builder token(String token) {
            this.token = token;
            return this;
        }

        /**
         * Enables logging for the clients. Also configures the logging level, defaults to BASIC if
         * null.
         *
         * @param debug the debug
         * @param level the level
         * @return the builder
         */
        public Builder debug(boolean debug, Level level) {
            this.debug = debug;
            if (level == null) {
                this.level = Level.BASIC;
            }
            this.level = level;
            return this;
        }

        /**
         * Build sdk config.
         *
         * @return the sdk config
         */
        public SdkConfig build() {
            requireSet(apiUrl, "apiUrl is required");

            boolean hasToken = isSet(token);
            boolean hasCredentials = isSet(username) && isSet(password);

            if (hasToken && hasCredentials) {
                throw new IllegalStateException(
                    "Provide either token() or credentials(), not both"
                );
            }
            if (!hasToken && !hasCredentials) {
                throw new IllegalStateException(
                    "Authentication required: provide token() or credentials()"
                );
            }
            if (hasCredentials) {
                requireSet(authApiUrl, "authApiUrl is required when using credentials()");
            }

            AuthProvider auth = hasToken
                ? AuthProvider.ofToken(token)
                : AuthProvider.ofCredentials(authApiUrl, username, password);

            return new SdkConfig(apiUrl, auth, debug, level);
        }
    }
}

