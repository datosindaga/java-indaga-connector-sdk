package es.itg.flythings.dataspace.sdk.resources.contractdefinition.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.itg.flythings.dataspace.sdk.edc.dto.CriterionDTO;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.enums.ContractState;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Contract definition output dto.
 */

/**
 * Represents a Contract Definition created by a Participant.
 *
 * <p>
 * Describes how assets are linked to access and contract policies within the dataspace, including
 * metadata and creation timestamp.
 * </p>
 */
public class ContractDefinitionOutputDTO {

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Object context;

    private String accessPolicyId;

    private String contractPolicyId;

    private List<CriterionDTO> assetsSelector;

    private Map<String, Object> privateProperties = new HashMap<>();

    private ContractState state;

    private Long createdAt;

    /**
     * Instantiates a new Contract definition output dto.
     */
    public ContractDefinitionOutputDTO() {
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
     * Gets access policy id.
     *
     * @return the access policy id
     */
    public String getAccessPolicyId() {
        return accessPolicyId;
    }

    /**
     * Sets access policy id.
     *
     * @param accessPolicyId the access policy id
     */
    public void setAccessPolicyId(String accessPolicyId) {
        this.accessPolicyId = accessPolicyId;
    }

    /**
     * Gets assets selector.
     *
     * @return the assets selector
     */
    public List<CriterionDTO> getAssetsSelector() {
        return assetsSelector;
    }

    /**
     * Sets assets selector.
     *
     * @param assetsSelector the assets selector
     */
    public void setAssetsSelector(
        List<CriterionDTO> assetsSelector) {
        this.assetsSelector = assetsSelector;
    }

    /**
     * Gets contract policy id.
     *
     * @return the contract policy id
     */
    public String getContractPolicyId() {
        return contractPolicyId;
    }

    /**
     * Sets contract policy id.
     *
     * @param contractPolicyId the contract policy id
     */
    public void setContractPolicyId(String contractPolicyId) {
        this.contractPolicyId = contractPolicyId;
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

    public ContractState getState() {
        return state;
    }

    public void setState(ContractState state) {
        this.state = state;
    }
}
