package es.itg.flythings.dataspace.exceptions;

import feign.Response;

public class SdkNotFoundException extends Exception {

    public SdkNotFoundException(Response response) {
    }
}
