package es.itg.flythings.dataspace.sdk.edc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Amazon S3 data address ({@code type = "AmazonS3"}). */
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

    public S3DataAddressDTO() {
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

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectPrefix() {
        return objectPrefix;
    }

    public void setObjectPrefix(String objectPrefix) {
        this.objectPrefix = objectPrefix;
    }

    public String getEndpointOverride() {
        return endpointOverride;
    }

    public void setEndpointOverride(String endpointOverride) {
        this.endpointOverride = endpointOverride;
    }

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }
}
