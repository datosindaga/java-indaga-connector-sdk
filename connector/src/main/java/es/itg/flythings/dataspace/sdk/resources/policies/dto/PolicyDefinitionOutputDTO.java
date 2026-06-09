package es.itg.flythings.dataspace.sdk.resources.policies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Policy Definition created by a Participant.
 *
 * <p>
 * Contains the metadata and ODRL policy associated with a defined policy object. Typically used
 * when retrieving existing policy definitions from the connector.
 * </p>
 */
public class PolicyDefinitionOutputDTO {

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Map<String, Object> context = new HashMap<>();

    private Map<String, Object> policy = new HashMap<>();

    private Map<String, Object> privateProperties = new HashMap<>();

    /**
     * Instantiates a new Policy definition output dto.
     */
    public PolicyDefinitionOutputDTO() {
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
     * Gets policy.
     *
     * @return the policy
     */
    public Map<String, Object> getPolicy() {
        return policy;
    }

    /**
     * Sets policy.
     *
     * @param policy the policy
     */
    public void setPolicy(Map<String, Object> policy) {
        this.policy = policy;
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
}
