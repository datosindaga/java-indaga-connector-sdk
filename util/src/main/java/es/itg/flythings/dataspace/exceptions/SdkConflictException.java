package es.itg.flythings.dataspace.exceptions;

import feign.Response;

public class SdkConflictException extends Exception {

    public SdkConflictException(Response response) {
    }
}
