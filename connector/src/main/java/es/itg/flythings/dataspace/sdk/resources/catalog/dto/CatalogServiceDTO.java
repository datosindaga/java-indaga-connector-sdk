package es.itg.flythings.dataspace.sdk.resources.catalog.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

/**
 * The type Catalog service dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogServiceDTO {

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("dcat:endpointURL")
    @JsonAlias("endpointUrl")
    private String endpointUrl;

    @JsonProperty("dcat:endpointDescription")
    @JsonAlias("endpointDescription")
    private String endpointDescription;

    private Map<String, Object> properties;

    /**
     * Instantiates a new Catalog service dto.
     */
    public CatalogServiceDTO() {
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
     * Gets endpoint url.
     *
     * @return the endpoint url
     */
    public String getEndpointUrl() {
        return endpointUrl;
    }

    /**
     * Sets endpoint url.
     *
     * @param endpointUrl the endpoint url
     */
    public void setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    /**
     * Gets endpoint description.
     *
     * @return the endpoint description
     */
    public String getEndpointDescription() {
        return endpointDescription;
    }

    /**
     * Sets endpoint description.
     *
     * @param endpointDescription the endpoint description
     */
    public void setEndpointDescription(String endpointDescription) {
        this.endpointDescription = endpointDescription;
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
}
