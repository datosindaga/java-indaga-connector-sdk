package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The Sdk not found exception. Indicates that the resource has not been found. Corresponds with the
 * 404 http error.
 */
public class SdkNotFoundException extends SdkException {

    /**
     * Instantiates a new Sdk not found exception.
     *
     * @param res the res
     */
    public SdkNotFoundException(Response res) {
        super(res);
    }

    /**
     * Instantiates a new Sdk not found exception.
     *
     * @param message the message
     */
    public SdkNotFoundException(String message) {
        super(message);
    }

}
