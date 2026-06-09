package es.itg.flythings.dataspace.sdk.exceptions;

import feign.Response;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * The type Sdk exception.
 */
public abstract class SdkException extends Exception {

    private final int statusCode;
    private final String responseBody;

    /**
     * Instantiates a new Sdk exception.
     *
     * @param message the message
     */
    protected SdkException(String message) {
        super(message);
        this.statusCode = -1;
        this.responseBody = null;
    }

    /**
     * Instantiates a new Sdk exception.
     *
     * @param res the res
     */
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

    /**
     * Gets status code.
     *
     * @return the status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Gets response body.
     *
     * @return the response body
     */
    public String getResponseBody() {
        return responseBody;
    }
}
