package es.itg.flythings.dataspace.sdk.client;


import es.itg.flythings.dataspace.sdk.dto.TokenResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * The Login client.
 */
public interface LoginClient {

    /**
     * Login endpoint.
     *
     * @param base64Credentials the base 64 credentials
     * @return the token response
     */
    @RequestLine("GET /login")
    @Headers("Authorization: Basic {credentials}")
    TokenResponse login(@Param("credentials") String base64Credentials);
}
