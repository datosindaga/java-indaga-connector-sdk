package es.itg.flythings.dataspace.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

public class SdkErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        return switch (response.status()) {
            case 400 -> new SdkBadRequestException(response);
            case 404 -> new SdkNotFoundException(response);
            case 409 -> new SdkConflictException(response);
            default -> new SdkServerException(response);
        };
    }
}
