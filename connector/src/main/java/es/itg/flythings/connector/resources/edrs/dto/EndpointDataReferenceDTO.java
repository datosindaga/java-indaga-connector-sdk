package es.itg.flythings.connector.resources.edrs.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Endpoint data reference dto.
 */
public class EndpointDataReferenceDTO {

    @JsonProperty("@context")
    private Object context;

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    private String transferProcessId;

    private String agreementId;

    private String contractNegotiationId;

    private String assetId;

    private String providerId;

    private Long createdAt;

    /**
     * Instantiates a new Endpoint data reference dto.
     */
    public EndpointDataReferenceDTO() {
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
     * Gets transfer process id.
     *
     * @return the transfer process id
     */
    public String getTransferProcessId() {
        return transferProcessId;
    }

    /**
     * Sets transfer process id.
     *
     * @param transferProcessId the transfer process id
     */
    public void setTransferProcessId(String transferProcessId) {
        this.transferProcessId = transferProcessId;
    }

    /**
     * Gets agreement id.
     *
     * @return the agreement id
     */
    public String getAgreementId() {
        return agreementId;
    }

    /**
     * Sets agreement id.
     *
     * @param agreementId the agreement id
     */
    public void setAgreementId(String agreementId) {
        this.agreementId = agreementId;
    }

    /**
     * Gets contract negotiation id.
     *
     * @return the contract negotiation id
     */
    public String getContractNegotiationId() {
        return contractNegotiationId;
    }

    /**
     * Sets contract negotiation id.
     *
     * @param contractNegotiationId the contract negotiation id
     */
    public void setContractNegotiationId(String contractNegotiationId) {
        this.contractNegotiationId = contractNegotiationId;
    }

    /**
     * Gets asset id.
     *
     * @return the asset id
     */
    public String getAssetId() {
        return assetId;
    }

    /**
     * Sets asset id.
     *
     * @param assetId the asset id
     */
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    /**
     * Gets provider id.
     *
     * @return the provider id
     */
    public String getProviderId() {
        return providerId;
    }

    /**
     * Sets provider id.
     *
     * @param providerId the provider id
     */
    public void setProviderId(String providerId) {
        this.providerId = providerId;
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
}
