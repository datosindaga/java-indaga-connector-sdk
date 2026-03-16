package es.itg.flythings.connector.resources.contractagreements.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Contract Agreement established between two Participants.
 *
 * <p>
 * Contains references to the agreed asset, the involved parties, and the contract signing
 * timestamp. Includes the associated policy describing the terms and constraints of usage.
 * </p>
 */
public class ContractAgreementDTO {

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    private String assetId;

    private String consumerId;

    private String providerId;

    private Long contractSigningDate;

    private PolicyDTO policy;

    /**
     * Instantiates a new Contract agreement dto.
     */
    public ContractAgreementDTO() {
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
     * Gets consumer id.
     *
     * @return the consumer id
     */
    public String getConsumerId() {
        return consumerId;
    }

    /**
     * Sets consumer id.
     *
     * @param consumerId the consumer id
     */
    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
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
     * Gets contract signing date.
     *
     * @return the contract signing date
     */
    public Long getContractSigningDate() {
        return contractSigningDate;
    }

    /**
     * Sets contract signing date.
     *
     * @param contractSigningDate the contract signing date
     */
    public void setContractSigningDate(Long contractSigningDate) {
        this.contractSigningDate = contractSigningDate;
    }

    /**
     * Gets policy.
     *
     * @return the policy
     */
    public PolicyDTO getPolicy() {
        return policy;
    }

    /**
     * Sets policy.
     *
     * @param policy the policy
     */
    public void setPolicy(PolicyDTO policy) {
        this.policy = policy;
    }
}
