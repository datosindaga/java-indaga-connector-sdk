package es.itg.flythings.dataspace.sdk.resources.policies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a request to evaluate a Policy within a given scope.
 *
 * <p>
 * Used to trigger or configure a policy evaluation plan for permissions, prohibitions, or
 * obligations under a specific evaluation context or scope.
 * </p>
 */
public class PolicyEvaluationPlanRequestDTO {

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Object context;

    private String policyScope;

    /**
     * Instantiates a new Policy evaluation plan request dto.
     */
    public PolicyEvaluationPlanRequestDTO() {
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
     * Gets policy scope.
     *
     * @return the policy scope
     */
    public String getPolicyScope() {
        return policyScope;
    }

    /**
     * Sets policy scope.
     *
     * @param policyScope the policy scope
     */
    public void setPolicyScope(String policyScope) {
        this.policyScope = policyScope;
    }
}
