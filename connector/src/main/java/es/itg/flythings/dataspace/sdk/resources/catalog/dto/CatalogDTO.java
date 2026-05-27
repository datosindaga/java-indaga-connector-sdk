package es.itg.flythings.dataspace.sdk.resources.catalog.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * The type Catalog dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogDTO {

    @JsonProperty("@context")
    private Object context;

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("dcat:distribution")
    @JsonAlias("distribution")
    private List<DistributionDTO> distribution;

    @JsonProperty("dcat:dataset")
    @JsonAlias("dataset")
    private List<DatasetDTO> dataset;

    @JsonProperty("dcat:catalog")
    @JsonAlias("catalog")
    private List<CatalogDTO> catalog;

    @JsonProperty("dcat:service")
    @JsonAlias("service")
    private List<CatalogServiceDTO> service;

    @JsonProperty("dspace:participantId")
    @JsonAlias("participantId")
    private String participantId;

    @JsonProperty("id")
    private String assetId;

    private String description;

    private String isCatalog;

    /**
     * Instantiates a new Catalog dto.
     */
    public CatalogDTO() {
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
     * Gets dataset.
     *
     * @return the dataset
     */
    public List<DatasetDTO> getDataset() {
        return dataset;
    }

    /**
     * Sets dataset.
     *
     * @param dataset the dataset
     */
    public void setDataset(List<DatasetDTO> dataset) {
        this.dataset = dataset;
    }

    /**
     * Gets catalog.
     *
     * @return the catalog
     */
    public List<CatalogDTO> getCatalog() {
        return catalog;
    }

    /**
     * Sets catalog.
     *
     * @param catalog the catalog
     */
    public void setCatalog(List<CatalogDTO> catalog) {
        this.catalog = catalog;
    }

    /**
     * Gets service.
     *
     * @return the service
     */
    public List<CatalogServiceDTO> getService() {
        return service;
    }

    /**
     * Sets service.
     *
     * @param service the service
     */
    public void setService(List<CatalogServiceDTO> service) {
        this.service = service;
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
     * Gets participant id.
     *
     * @return the participant id
     */
    public String getParticipantId() {
        return participantId;
    }

    /**
     * Sets participant id.
     *
     * @param participantId the participant id
     */
    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsCatalog() {
        return isCatalog;
    }

    public void setIsCatalog(String isCatalog) {
        this.isCatalog = isCatalog;
    }
}

