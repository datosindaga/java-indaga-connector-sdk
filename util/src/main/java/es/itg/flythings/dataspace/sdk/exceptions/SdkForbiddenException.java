package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The type Sdk forbidden exception. Indicates that the resource has not been found. Corresponds
 * with * the 403 http error.
 */
public class SdkForbiddenException extends SdkException {

    public SdkForbiddenException(Response res) {
        super(res);
    }

    public SdkForbiddenException(String message) {
        super(message);
    }

}
