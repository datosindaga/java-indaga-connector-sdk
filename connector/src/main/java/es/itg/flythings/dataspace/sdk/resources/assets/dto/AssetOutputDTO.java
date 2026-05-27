package es.itg.flythings.dataspace.sdk.resources.assets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.itg.flythings.dataspace.sdk.edc.dto.DataAddressDTO;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents an Asset belonging to a Participant as returned by the dataspace API.
 *
 * <p>
 * This DTO contains both public and private metadata, along with creation timestamps and technical
 * connection details under the dataAddress field.
 * </p>
 */
public class AssetOutputDTO {

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Map<String, Object> context = new HashMap<>();

    private Long createdAt;

    private Map<String, Object> properties = new HashMap<>();

    private Map<String, Object> privateProperties = new HashMap<>();

    private DataAddressDTO dataAddress;

    /**
     * Instantiates a new Asset output dto.
     */
    public AssetOutputDTO() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
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
     * Gets context.
     *
     * @return the context
     */
    public Map<String, Object> getContext() {
        return context;
    }

    /**
     * Sets context.
     *
     * @param context the context
     */
    public void setContext(Map<String, Object> context) {
        this.context = context;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets properties.
     *
     * @return the properties
     */
    public Map<String, Object> getProperties() {
        return properties;
    }

    /**
     * Sets properties.
     *
     * @param properties the properties
     */
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    /**
     * Gets private properties.
     *
     * @return the private properties
     */
    public Map<String, Object> getPrivateProperties() {
        return privateProperties;
    }

    /**
     * Sets private properties.
     *
     * @param privateProperties the private properties
     */
    public void setPrivateProperties(Map<String, Object> privateProperties) {
        this.privateProperties = privateProperties;
    }

    /**
     * Gets data address.
     *
     * @return the data address
     */
    public DataAddressDTO getDataAddress() {
        return dataAddress;
    }

    /**
     * Sets data address.
     *
     * @param dataAddress the data address
     */
    public void setDataAddress(DataAddressDTO dataAddress) {
        this.dataAddress = dataAddress;
    }
}
