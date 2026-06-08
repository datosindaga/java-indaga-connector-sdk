package es.itg.flythings.dataspace.sdk.edc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Azure Blob Storage data address ({@code type = "AzureStorage"}).
 */
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

    /**
     * Instantiates a new Azure storage data adress dto.
     */
    public AzureStorageDataAdressDTO() {
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
     * Gets account.
     *
     * @return the account
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets account.
     *
     * @param account the account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * Gets container.
     *
     * @return the container
     */
    public String getContainer() {
        return container;
    }

    /**
     * Sets container.
     *
     * @param container the container
     */
    public void setContainer(String container) {
        this.container = container;
    }

    /**
     * Gets blob name.
     *
     * @return the blob name
     */
    public String getBlobName() {
        return blobName;
    }

    /**
     * Sets blob name.
     *
     * @param blobName the blob name
     */
    public void setBlobName(String blobName) {
        this.blobName = blobName;
    }

    /**
     * Gets blob prefix.
     *
     * @return the blob prefix
     */
    public String getBlobPrefix() {
        return blobPrefix;
    }

    /**
     * Sets blob prefix.
     *
     * @param blobPrefix the blob prefix
     */
    public void setBlobPrefix(String blobPrefix) {
        this.blobPrefix = blobPrefix;
    }

    /**
     * Gets account key.
     *
     * @return the account key
     */
    public String getAccountKey() {
        return accountKey;
    }

    /**
     * Sets account key.
     *
     * @param accountKey the account key
     */
    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    /**
     * Gets sas token.
     *
     * @return the sas token
     */
    public String getSasToken() {
        return sasToken;
    }

    /**
     * Sets sas token.
     *
     * @param sasToken the sas token
     */
    public void setSasToken(String sasToken) {
        this.sasToken = sasToken;
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
     * Gets key name.
     *
     * @return the key name
     */
    public String getKeyName() {
        return keyName;
    }

    /**
     * Sets key name.
     *
     * @param keyName the key name
     */
    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
}