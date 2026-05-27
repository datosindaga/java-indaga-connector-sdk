package es.itg.flythings.dataspace.sdk.resources.catalog.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.itg.flythings.dataspace.sdk.edc.dto.FormatDTO;
import java.util.List;

/**
 * The type Distribution dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DistributionDTO {

    @JsonProperty("@type")
    private String type;

    @JsonProperty("odrl:hasPolicy")
    @JsonAlias({"hasPolicy"})
    private List<OfferPolicyDTO> hasPolicy;

    @JsonProperty("dcat:accessService")
    @JsonAlias({"accessService"})
    private CatalogServiceDTO accessService;

    @JsonProperty("dct:format")
    @JsonAlias({"format"})
    private FormatDTO format;

    /**
     * Instantiates a new Distribution dto.
     */
    public DistributionDTO() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
     * Gets access service.
     *
     * @return the access service
     */
    public CatalogServiceDTO getAccessService() {
        return accessService;
    }

    /**
     * Sets access service.
     *
     * @param accessService the access service
     */
    public void setAccessService(CatalogServiceDTO accessService) {
        this.accessService = accessService;
    }

    /**
     * Gets format.
     *
     * @return the format
     */
    public FormatDTO getFormat() {
        return format;
    }

    /**
     * Sets format.
     *
     * @param format the format
     */
    public void setFormat(FormatDTO format) {
        this.format = format;
    }
}
