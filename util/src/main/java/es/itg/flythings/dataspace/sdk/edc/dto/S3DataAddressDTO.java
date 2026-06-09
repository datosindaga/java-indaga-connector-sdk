package es.itg.flythings.dataspace.sdk.edc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Amazon S3 data address ({@code type = "AmazonS3"}).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class S3DataAddressDTO implements DataAddressDTO {

    @JsonProperty("@type")
    private String jsonLdType;

    @JsonProperty("type")
    private String type;

    private String region;
    private String bucketName;
    private String objectName;
    private String objectPrefix;
    private String endpointOverride;
    private String secretAccessKey;
    private String accessKeyId;
    private String keyName;

    /**
     * Instantiates a new S 3 data address dto.
     */
    public S3DataAddressDTO() {
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
     * Gets region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets region.
     *
     * @param region the region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets bucket name.
     *
     * @return the bucket name
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * Sets bucket name.
     *
     * @param bucketName the bucket name
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * Gets object name.
     *
     * @return the object name
     */
    public String getObjectName() {
        return objectName;
    }

    /**
     * Sets object name.
     *
     * @param objectName the object name
     */
    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    /**
     * Gets object prefix.
     *
     * @return the object prefix
     */
    public String getObjectPrefix() {
        return objectPrefix;
    }

    /**
     * Sets object prefix.
     *
     * @param objectPrefix the object prefix
     */
    public void setObjectPrefix(String objectPrefix) {
        this.objectPrefix = objectPrefix;
    }

    /**
     * Gets endpoint override.
     *
     * @return the endpoint override
     */
    public String getEndpointOverride() {
        return endpointOverride;
    }

    /**
     * Sets endpoint override.
     *
     * @param endpointOverride the endpoint override
     */
    public void setEndpointOverride(String endpointOverride) {
        this.endpointOverride = endpointOverride;
    }

    /**
     * Gets secret access key.
     *
     * @return the secret access key
     */
    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    /**
     * Sets secret access key.
     *
     * @param secretAccessKey the secret access key
     */
    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    /**
     * Gets access key id.
     *
     * @return the access key id
     */
    public String getAccessKeyId() {
        return accessKeyId;
    }

    /**
     * Sets access key id.
     *
     * @param accessKeyId the access key id
     */
    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
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
