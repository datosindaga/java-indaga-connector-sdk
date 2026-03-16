package es.itg.flythings.auth.client;


import es.itg.flythings.auth.dto.TokenResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface LoginClient {

    @RequestLine("GET /login")
    @Headers("Authorization: Basic {credentials}")
    TokenResponse login(@Param("credentials") String base64Credentials);
}
