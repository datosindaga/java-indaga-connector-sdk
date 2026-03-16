package es.itg.flythings.dataspace.exceptions;

import feign.Response;

public class SdkBadRequestException extends Exception {

    public SdkBadRequestException(Response response) {
        super(response.reason());
    }

    public SdkBadRequestException(String error) {
        super(error);
    }
}
