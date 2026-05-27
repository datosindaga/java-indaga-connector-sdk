package es.itg.flythings.dataspace.sdk.edc.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

/** HTTP-backed data address ({@code type = "HttpData"} or IDS HTTP variant). */
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

    public HttpDataAddressDTO() {
    }

    /** Builds a {@code GET} request to {@link #endpoint} with {@code Authorization} header. */
    public HttpRequest toHttpRequest() {
        return HttpRequest.newBuilder()
            .uri(URI.create(endpoint))
            .GET()
            .header("Authorization", authorization)
            .build();
    }

    @JsonAnySetter
    public void putAdditional(String key, Object value) {
        additional.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditional() {
        return additional;
    }

    public void setAdditional(Map<String, Object> additional) {
        this.additional = additional;
    }

    @Override
    public String getJsonLdType() {
        return jsonLdType;
    }

    public void setJsonLdType(String jsonLdType) {
        this.jsonLdType = jsonLdType;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Boolean getProxyPath() {
        return proxyPath;
    }

    public void setProxyPath(Boolean proxyPath) {
        this.proxyPath = proxyPath;
    }

    public Boolean getProxyQueryParams() {
        return proxyQueryParams;
    }

    public void setProxyQueryParams(Boolean proxyQueryParams) {
        this.proxyQueryParams = proxyQueryParams;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public Object getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(Object queryParams) {
        this.queryParams = queryParams;
    }

    public Object getParameterization() {
        return parameterization;
    }

    public void setParameterization(Object parameterization) {
        this.parameterization = parameterization;
    }

    public Object getDataSink() {
        return dataSink;
    }

    public void setDataSink(Object dataSink) {
        this.dataSink = dataSink;
    }
}
