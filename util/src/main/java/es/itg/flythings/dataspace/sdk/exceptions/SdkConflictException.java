package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The type Sdk conflict exception. Indicates that the resource has not been found. Corresponds with
 * the 409 http error.
 */
public class SdkConflictException extends Exception {

    /**
     * Instantiates a new Sdk conflict exception.
     *
     * @param response the response
     */
    public SdkConflictException(Response response) {
    }
}
