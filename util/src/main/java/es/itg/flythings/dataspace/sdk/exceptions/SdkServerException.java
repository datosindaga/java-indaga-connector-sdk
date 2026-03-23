package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The Sdk server exception. Its a generic exception, generally for unmapped or internal errors
 */
public class SdkServerException extends Exception {

    private final Response innerResponse;


    /**
     * Instantiates a new Sdk server exception.
     *
     * @param message the message
     */
    public SdkServerException(String message) {
        super(message);
        this.innerResponse = null;
    }

    /**
     * Instantiates a new Sdk server exception.
     *
     * @param res the res
     */
    public SdkServerException(Response res) {
        super(res.reason());
        this.innerResponse = res;
    }

    /**
     * Gets inner response.
     *
     * @return the inner response
     */
    public Response getInnerResponse() {
        return innerResponse;
    }
}
