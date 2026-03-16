package es.itg.flythings.dataspace.exceptions;

import feign.Response;

public class SdkServerException extends Exception {

    private final Response innerResponse;


    public SdkServerException(String message) {
        super(message);
        this.innerResponse = null;
    }

    public SdkServerException(Response res) {
        super(res.reason());
        this.innerResponse = res;
    }

    public Response getInnerResponse() {
        return innerResponse;
    }
}
