package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The Sdk server exception. It's a generic exception, generally for unmapped or internal errors
 */
public class SdkServerException extends SdkException {

    /**
     * Instantiates a new Sdk server exception.
     *
     * @param res the res
     */
    public SdkServerException(Response res) {
        super(res);
    }

    /**
     * Instantiates a new Sdk server exception.
     *
     * @param message the message
     */
    public SdkServerException(String message) {
        super(message);
    }

}
