package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The type Sdk unauthorized exception. Indicates that the resource has not been found. Corresponds
 * with * the 409 http error.
 */
public class SdkUnauthorizedException extends SdkException {

    public SdkUnauthorizedException(Response res) {
        super(res);
    }

    public SdkUnauthorizedException(String message) {
        super(message);
    }

}
