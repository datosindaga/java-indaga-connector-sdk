package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * The Sdk error decoder. Maps http status codes to SDK specific exceptions
 */
public class SdkErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        return switch (response.status()) {
            case 400 -> new SdkBadRequestException(response);
            case 401 -> new SdkUnauthorizedException(response);
            case 403 -> new SdkForbiddenException(response);
            case 404 -> new SdkNotFoundException(response);
            case 409 -> new SdkConflictException(response);
            default -> new SdkServerException(response);
        };
    }
}
