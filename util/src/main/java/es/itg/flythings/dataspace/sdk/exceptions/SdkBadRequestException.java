package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The type Sdk bad request exception. Indicates that the request is malformed. Corresponds with the
 * 400 http error.
 */
public class SdkBadRequestException extends SdkException {

    /**
     * Instantiates a new Sdk bad request exception.
     *
     * @param res the res
     */
    public SdkBadRequestException(Response res) {
        super(res);
    }

    /**
     * Instantiates a new Sdk bad request exception.
     *
     * @param message the message
     */
    public SdkBadRequestException(String message) {
        super(message);
    }

}
