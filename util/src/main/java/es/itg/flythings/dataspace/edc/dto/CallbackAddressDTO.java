package es.itg.flythings.dataspace.edc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a callback endpoint configuration used by the connector to notify participants about
 * events.
 *
 * <p>A CallbackAddress defines where and how event notifications are delivered. It may include
 * authentication credentials, the list of subscribed events, and a flag indicating whether
 * callbacks are transactional.</p>
 */
public class CallbackAddressDTO {

    /**
     * JSON-LD type of the callback object, typically {@code "CallbackAddress"}.
     */
    @JsonProperty("@type")
    private String type;

    /**
     * Identifier referencing an authorization configuration (e.g., an OAuth2 client) to be used for
     * callbacks. Commonly used when the receiving endpoint requires token-based authentication.
     *
     * <p>Example: {@code auth-code-client-1}</p>
     */
    private String authCodeId;

    /**
     * Static authentication key included in the callback request headers. Used when the receiving
     * service expects a pre-shared secret (e.g., {@code Authorization: <authKey>}).
     *
     * <p>Example: {@code my-secret-api-key}</p>
     */
    private String authKey;

    /**
     * List of event names that this callback endpoint subscribes to, for example:
     * <ul>
     *   <li>{@code contract.negotiation.completed}</li>
     *   <li>{@code transfer.process.started}</li>
     *   <li>{@code transfer.process.completed}</li>
     * </ul>
     */
    private List<String> events;

    /**
     * Indicates whether the callback must be processed transactionally.
     *
     * <p>When {@code true}, event delivery is part of the transactional process and must succeed
     * for the operation to complete. When {@code false}, callbacks are treated as best-effort
     * notifications.</p>
     */
    private Boolean transactional;

    /**
     * The endpoint URI to which event callbacks will be sent. Must be a valid HTTP or HTTPS URL
     * accessible to the connector.
     *
     * <p>Example: {@code https://participant.example.com/api/events}</p>
     */
    private String uri;

    /**
     * Instantiates a new Callback address dto.
     */
    public CallbackAddressDTO() {
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets auth code id.
     *
     * @return the auth code id
     */
    public String getAuthCodeId() {
        return authCodeId;
    }

    /**
     * Sets auth code id.
     *
     * @param authCodeId the auth code id
     */
    public void setAuthCodeId(String authCodeId) {
        this.authCodeId = authCodeId;
    }

    /**
     * Gets auth key.
     *
     * @return the auth key
     */
    public String getAuthKey() {
        return authKey;
    }

    /**
     * Sets auth key.
     *
     * @param authKey the auth key
     */
    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    /**
     * Gets events.
     *
     * @return the events
     */
    public List<String> getEvents() {
        return events;
    }

    /**
     * Sets events.
     *
     * @param events the events
     */
    public void setEvents(List<String> events) {
        this.events = events;
    }

    /**
     * Gets transactional.
     *
     * @return the transactional
     */
    public Boolean getTransactional() {
        return transactional;
    }

    /**
     * Sets transactional.
     *
     * @param transactional the transactional
     */
    public void setTransactional(Boolean transactional) {
        this.transactional = transactional;
    }

    /**
     * Gets uri.
     *
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets uri.
     *
     * @param uri the uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }
}
