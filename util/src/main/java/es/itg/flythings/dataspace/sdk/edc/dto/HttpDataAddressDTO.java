package es.itg.flythings.dataspace.sdk.edc.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * HTTP-backed data address ({@code type = "HttpData"} or IDS HTTP variant).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpDataAddressDTO implements DataAddressDTO {

    @JsonProperty("@type")
    private String jsonLdType;

    @JsonProperty("type")
    private String type;

    private String baseUrl;
    private String basePath;
    private String method;
    private Boolean proxyPath;
    private Boolean proxyQueryParams;
    private String endpoint;
    private String authKey;
    private String authCode;
    private String authorization;
    private Object queryParams;
    private Object parameterization;
    private Object dataSink;

    private Map<String, Object> additional = new HashMap<>();

    /**
     * Instantiates a new Http data address dto.
     */
    public HttpDataAddressDTO() {
    }

    /**
     * Builds a {@code GET} request to {@link #endpoint} with {@code Authorization} header.  @return
     * the http request
     */
    public HttpRequest toHttpRequest() {
        return HttpRequest.newBuilder()
            .uri(URI.create(endpoint))
            .GET()
            .header("Authorization", authorization)
            .build();
    }

    /**
     * Put additional.
     *
     * @param key   the key
     * @param value the value
     */
    @JsonAnySetter
    public void putAdditional(String key, Object value) {
        additional.put(key, value);
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

    @Override
    public String getJsonLdType() {
        return jsonLdType;
    }

    /**
     * Sets json ld type.
     *
     * @param jsonLdType the json ld type
     */
    public void setJsonLdType(String jsonLdType) {
        this.jsonLdType = jsonLdType;
    }

    @Override
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
     * Gets base path.
     *
     * @return the base path
     */
    public String getBasePath() {
        return basePath;
    }

    /**
     * Sets base path.
     *
     * @param basePath the base path
     */
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    /**
     * Gets method.
     *
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets method.
     *
     * @param method the method
     */
    public void setMethod(String method) {
        this.method = method;
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
     * Gets endpoint.
     *
     * @return the endpoint
     */
    public String getEndpoint() {
        return endpoint;
    }

    /**
     * Sets endpoint.
     *
     * @param endpoint the endpoint
     */
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
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
     * Gets auth code.
     *
     * @return the auth code
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * Sets auth code.
     *
     * @param authCode the auth code
     */
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    /**
     * Gets authorization.
     *
     * @return the authorization
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * Sets authorization.
     *
     * @param authorization the authorization
     */
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    /**
     * Gets query params.
     *
     * @return the query params
     */
    public Object getQueryParams() {
        return queryParams;
    }

    /**
     * Sets query params.
     *
     * @param queryParams the query params
     */
    public void setQueryParams(Object queryParams) {
        this.queryParams = queryParams;
    }

    /**
     * Gets parameterization.
     *
     * @return the parameterization
     */
    public Object getParameterization() {
        return parameterization;
    }

    /**
     * Sets parameterization.
     *
     * @param parameterization the parameterization
     */
    public void setParameterization(Object parameterization) {
        this.parameterization = parameterization;
    }

    /**
     * Gets data sink.
     *
     * @return the data sink
     */
    public Object getDataSink() {
        return dataSink;
    }

    /**
     * Sets data sink.
     *
     * @param dataSink the data sink
     */
    public void setDataSink(Object dataSink) {
        this.dataSink = dataSink;
    }
}
