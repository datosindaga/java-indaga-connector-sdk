package es.itg.flythings.auth.config;

import es.itg.flythings.auth.provider.AuthProvider;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public final class BearerAuthInterceptor implements RequestInterceptor {

    private final AuthProvider authProvider;

    public BearerAuthInterceptor(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "Bearer " + authProvider.getToken());
    }
}
