package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The type Sdk conflict exception. Indicates that the resource has not been found. Corresponds with
 * * the 409 http error.
 */
public class SdkConflictException extends SdkException {

    /**
     * Instantiates a new Sdk conflict exception.
     *
     * @param res the res
     */
    public SdkConflictException(Response res) {
        super(res);
    }

    /**
     * Instantiates a new Sdk conflict exception.
     *
     * @param message the message
     */
    public SdkConflictException(String message) {
        super(message);
    }

}
