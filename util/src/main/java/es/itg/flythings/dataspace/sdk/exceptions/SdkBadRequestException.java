package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The type Sdk bad request exception. Indicates that the request is malformed. Corresponds with the
 * 400 http error.
 */
public class SdkBadRequestException extends Exception {

    /**
     * Instantiates a new Sdk bad request exception.
     *
     * @param response the response
     */
    public SdkBadRequestException(Response response) {
        super(response.reason());
    }

    /**
     * Instantiates a new Sdk bad request exception.
     *
     * @param error the error
     */
    public SdkBadRequestException(String error) {
        super(error);
    }
}
