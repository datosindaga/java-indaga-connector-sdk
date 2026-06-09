package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The type Sdk forbidden exception. Indicates that the resource has not been found. Corresponds
 * with * the 403 http error.
 */
public class SdkForbiddenException extends SdkException {

    /**
     * Instantiates a new Sdk forbidden exception.
     *
     * @param res the res
     */
    public SdkForbiddenException(Response res) {
        super(res);
    }

    /**
     * Instantiates a new Sdk forbidden exception.
     *
     * @param message the message
     */
    public SdkForbiddenException(String message) {
        super(message);
    }

}
