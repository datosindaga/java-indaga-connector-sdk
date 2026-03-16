package es.itg.flythings.dataspace.edc.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

/**
 * EDC-style DataAddress describing how/where the asset's data is accessed.
 *
 * <p>Key field distinctions:</p>
 * <ul>
 *   <li>{@code @type} — JSON-LD class, typically {@code "DataAddress"}.</li>
 *   <li>{@code type} — concrete address mechanism, e.g. {@code "HttpData"}, {@code "S3"},
 *       {@code "AzureBlob"}.</li>
 *   <li>Common HTTP fields include {@code baseUrl}, {@code proxyPath}, and
 *       {@code proxyQueryParams}.</li>
 * </ul>
 *
 * <p>This DTO is future-proof: any unknown keys returned by the connector are accepted and
 * preserved in the {@link #additional} map.</p>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataAddressDTO {

    /**
     * JSON-LD class name of this object, typically {@code "DataAddress"}.
     */
    @JsonProperty("@type")
    private String type;

    /**
     * Concrete data address type, e.g. {@code "HttpData"}, {@code "S3"}, {@code "AzureBlob"}.
     */
    @JsonProperty("type")
    private String addressType;

    /**
     * Base URL for HTTP-based data addresses.
     *
     * <p>Example: {@code https://jsonplaceholder.typicode.com/todos}</p>
     */
    private String baseUrl;

    /**
     * If {@code true}, the connector proxies the path component of the request.
     */
    private Boolean proxyPath;

    /**
     * If {@code true}, the connector proxies the query parameters of the request.
     */
    private Boolean proxyQueryParams;

    /**
     * Endpoint URL for connector-to-connector or backend communication.
     */
    @JsonProperty("endpoint")
    private String endpoint;

    /**
     * Authorization value passed to the backend data source.
     */
    @JsonProperty("authorization")
    private String authorization;

    /**
     * Additional connector- or type-specific fields not explicitly modeled in this DTO.
     *
     * <p>Captures any present or future EDC keys, for example: {@code method},
     * {@code proxyBody}, {@code header:*}, {@code authKey}, {@code secretName}, {@code bucketName},
     * {@code containerName}, etc.</p>
     *
     * <p>Example:</p>
     * <pre>{@code
     * {
     *   "method": "GET",
     *   "proxyBody": false,
     *   "header:Authorization": "Bearer ****"
     * }
     * }</pre>
     */
    private Map<String, Object> additional = new HashMap<>();

    /**
     * Instantiates a new Data address dto.
     */
    public DataAddressDTO() {
    }

    /**
     * Put additional.
     *
     * @param key   the key
     * @param value the value
     */
// ---------- JSON Any (extension) ----------
    @JsonAnySetter
    public void putAdditional(String key, Object value) {
        // Avoid overwriting known fields routed by Jackson:
        switch (key) {
            case "@type":
            case "type":
            case "baseUrl":
            case "proxyPath":
            case "proxyQueryParams":
                // Let Jackson setters handle these—ignore here.
                return;
            default:
                additional.put(key, value);
        }
    }

    /**
     * Gets additional.
     *
     * @return the additional
     */
    @JsonAnyGetter
    public Map<String, Object> getAdditional() {
        return additional;
    }

    /**
     * Sets additional.
     *
     * @param additional the additional
     */
    public void setAdditional(Map<String, Object> additional) {
        this.additional = additional;
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
     * Gets address type.
     *
     * @return the address type
     */
    public String getAddressType() {
        return addressType;
    }

    /**
     * Sets address type.
     *
     * @param addressType the address type
     */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
     * Gets base url.
     *
     * @return the base url
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Sets base url.
     *
     * @param baseUrl the base url
     */
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Gets proxy path.
     *
     * @return the proxy path
     */
    public Boolean getProxyPath() {
        return proxyPath;
    }

    /**
     * Sets proxy path.
     *
     * @param proxyPath the proxy path
     */
    public void setProxyPath(Boolean proxyPath) {
        this.proxyPath = proxyPath;
    }

    /**
     * Gets proxy query params.
     *
     * @return the proxy query params
     */
    public Boolean getProxyQueryParams() {
        return proxyQueryParams;
    }

    /**
     * Sets proxy query params.
     *
     * @param proxyQueryParams the proxy query params
     */
    public void setProxyQueryParams(Boolean proxyQueryParams) {
        this.proxyQueryParams = proxyQueryParams;
    }

    /**
     * Gets authorization.
     *
     * @return the authorization string
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * Sets authorization.
     */
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    /**
     * Gets the endpoint.
     *
     * @return the endpoint string
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Sets the endpoint.
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

}
