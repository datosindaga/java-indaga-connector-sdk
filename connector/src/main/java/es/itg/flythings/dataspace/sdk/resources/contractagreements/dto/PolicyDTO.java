package es.itg.flythings.dataspace.sdk.resources.contractagreements.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * Represents an ODRL Policy defining permissions, prohibitions, and obligations.
 *
 * <p>
 * Used inside Contract Agreements to describe usage terms for an Asset.
 * </p>
 */
public class PolicyDTO {

    @JsonProperty("@context")
    private Object context;

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    private List<Map<String, Object>> action;

    private List<Map<String, Object>> permission;

    private List<Map<String, Object>> prohibition;

    private List<Map<String, Object>> obligation;

    /**
     * Instantiates a new Policy dto.
     */
    public PolicyDTO() {
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
     * Gets action.
     *
     * @return the action
     */
    public List<Map<String, Object>> getAction() {
        return action;
    }

    /**
     * Sets action.
     *
     * @param action the action
     */
    public void setAction(List<Map<String, Object>> action) {
        this.action = action;
    }

    /**
     * Gets permission.
     *
     * @return the permission
     */
    public List<Map<String, Object>> getPermission() {
        return permission;
    }

    /**
     * Sets permission.
     *
     * @param permission the permission
     */
    public void setPermission(List<Map<String, Object>> permission) {
        this.permission = permission;
    }

    /**
     * Gets prohibition.
     *
     * @return the prohibition
     */
    public List<Map<String, Object>> getProhibition() {
        return prohibition;
    }

    /**
     * Sets prohibition.
     *
     * @param prohibition the prohibition
     */
    public void setProhibition(List<Map<String, Object>> prohibition) {
        this.prohibition = prohibition;
    }

    /**
     * Gets obligation.
     *
     * @return the obligation
     */
    public List<Map<String, Object>> getObligation() {
        return obligation;
    }

    /**
     * Sets obligation.
     *
     * @param obligation the obligation
     */
    public void setObligation(List<Map<String, Object>> obligation) {
        this.obligation = obligation;
    }
}
