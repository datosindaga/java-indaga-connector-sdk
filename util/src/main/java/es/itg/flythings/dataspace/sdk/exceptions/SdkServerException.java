package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;

/**
 * The Sdk server exception. It's a generic exception, generally for unmapped or internal errors
 */
public class SdkServerException extends SdkException {

    public SdkServerException(Response res) {
        super(res);
    }

    public SdkServerException(String message) {
        super(message);
    }

}
