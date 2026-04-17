package es.itg.flythings.dataspace.sdk.config;

import es.itg.flythings.dataspace.sdk.provider.AuthProvider;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * The Bearer auth interceptor. Handles the authentication by adding the Authorization header
 * automatically to all request made.
 */
public final class BearerAuthInterceptor implements RequestInterceptor {

    private final AuthProvider authProvider;

    /**
     * Instantiates a new Bearer auth interceptor.
     *
     * @param authProvider the auth provider
     */
    public BearerAuthInterceptor(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + authProvider.token());
    }
}
