package es.itg.flythings.dataspace.sdk.edc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Azure Blob Storage data address ({@code type = "AzureStorage"}). */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AzureStorageDataAdressDTO implements DataAddressDTO {

    @JsonProperty("@type")
    private String jsonLdType;

    @JsonProperty("type")
    private String type;

    private String account;
    private String container;
    private String blobName;
    private String blobPrefix;
    private String accountKey;
    private String sasToken;
    private String endpoint;
    private String keyName;

    public AzureStorageDataAdressDTO() {
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getBlobName() {
        return blobName;
    }

    public void setBlobName(String blobName) {
        this.blobName = blobName;
    }

    public String getBlobPrefix() {
        return blobPrefix;
    }

    public void setBlobPrefix(String blobPrefix) {
        this.blobPrefix = blobPrefix;
    }

    public String getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    public String getSasToken() {
        return sasToken;
    }

    public void setSasToken(String sasToken) {
        this.sasToken = sasToken;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
}