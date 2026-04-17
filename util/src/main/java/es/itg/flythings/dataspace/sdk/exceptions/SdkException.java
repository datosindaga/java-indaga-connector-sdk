package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class SdkException extends Exception {

    private final int statusCode;
    private final String responseBody;

    protected SdkException(String message) {
        super(message);
        this.statusCode = -1;
        this.responseBody = null;
    }

    protected SdkException(Response res) {
        super(buildMessage(res));
        this.statusCode = res.status();
        this.responseBody = readBody(res);
    }

    private static String buildMessage(Response res) {
        String body = readBody(res);
        return String.format("[%d %s] %s", res.status(), res.reason(),
            body != null ? body : "<empty body>");
    }

    private static String readBody(Response res) {
        try {
            if (res.body() == null) {
                return null;
            }
            return new String(res.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            return "<failed to read body: " + e.getMessage() + ">";
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}
