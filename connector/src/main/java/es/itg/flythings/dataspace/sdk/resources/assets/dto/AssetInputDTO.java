package es.itg.flythings.dataspace.sdk.resources.assets.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.itg.flythings.dataspace.sdk.edc.dto.DataAddressDTO;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents an Asset to be created or registered by a Participant within the dataspace.
 *
 * <p>An Asset describes data or resources made available for exchange.
 * It includes descriptive metadata, the technical data address (endpoint), and optional private
 * properties that are not exposed publicly.</p>
 */
public class AssetInputDTO {

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Object context;

    private DataAddressDTO dataAddress;

    private Map<String, Object> properties = new HashMap<>();

    private Map<String, Object> privateProperties = new HashMap<>();

    /**
     * Instantiates a new Asset input dto.
     */
    public AssetInputDTO() {
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
    public Object getContext() {
        return context;
    }

    /**
     * Sets context.
     *
     * @param context the context
     */
    public void setContext(Object context) {
        this.context = context;
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
