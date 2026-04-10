package es.itg.flythings.dataspace.sdk.resources.catalog.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Dataset dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailedDatasetDTO {

    @JsonProperty("@context")
    private Object context;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@id")
    private String id;

    @JsonProperty("dcat:distribution")
    @JsonAlias({"distribution"})
    private List<DistributionDTO> distribution;

    @JsonProperty("odrl:hasPolicy")
    @JsonAlias({"hasPolicy"})
    private List<OfferPolicyDTO> hasPolicy;

    @JsonProperty("provider")
    private String provider;

    /**
     * All other (public) properties go here. We: - Capture unknown top-level keys via
     *
     * @JsonAnySetter (flattened inputs) - Merge "properties" object if present (nested inputs) -
     * Serialize them ONLY under "properties" to keep our output consistent.
     */
    @JsonIgnore
    private Map<String, Object> publicProperties = new LinkedHashMap<>();

    /**
     * Instantiates a new Dataset dto.
     */
    public DetailedDatasetDTO() {
    }

    public DetailedDatasetDTO(DatasetDTO dataset, CatalogDTO catalog) {
        this.context = catalog.getContext();
        this.type = dataset.getType();
        this.id = dataset.getId();
        this.distribution = dataset.getDistribution();
        this.hasPolicy = dataset.getHasPolicy();
        this.provider = catalog.getParticipantId();
        this.publicProperties = dataset.getProperties();
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
     * Gets distribution.
     *
     * @return the distribution
     */
    public List<DistributionDTO> getDistribution() {
        return distribution;
    }

    /**
     * Sets distribution.
     *
     * @param distribution the distribution
     */
    public void setDistribution(
        List<DistributionDTO> distribution) {
        this.distribution = distribution;
    }

    /**
     * Gets has policy.
     *
     * @return the has policy
     */
    public List<OfferPolicyDTO> getHasPolicy() {
        return hasPolicy;
    }

    /**
     * Sets has policy.
     *
     * @param hasPolicy the has policy
     */
    public void setHasPolicy(List<OfferPolicyDTO> hasPolicy) {
        this.hasPolicy = hasPolicy;
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    /**
     * Always write our public properties under "properties" (not flattened).
     */
    @JsonProperty("properties")
    public Map<String, Object> getProperties() {
        return publicProperties.isEmpty() ? null : publicProperties;
    }

    /**
     * Accept nested "properties" if the provider sends them that way.
     */
    @JsonProperty("properties")
    public void setProperties(Map<String, Object> props) {
        if (props != null) {
            publicProperties.putAll(props);
        }
    }

    /**
     * Capture any unknown top-level key (i.e., flattened public property) on deserialize.
     */
    @JsonAnySetter
    public void captureFlattened(String key, Object value) {
        // Known JSON-LD / modeled fields will be bound first and won't come here.
        // If some provider sends extra top-level fields, we keep them as public properties.
        publicProperties.put(key, value);
    }

}

