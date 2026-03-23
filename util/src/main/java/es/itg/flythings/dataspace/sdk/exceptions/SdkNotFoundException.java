package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The Sdk not found exception. Indicates that the resource has not been found. Corresponds with the
 * 404 http error.
 */
public class SdkNotFoundException extends Exception {

    /**
     * Instantiates a new Sdk not found exception.
     *
     * @param response the response
     */
    public SdkNotFoundException(Response response) {
    }
}
