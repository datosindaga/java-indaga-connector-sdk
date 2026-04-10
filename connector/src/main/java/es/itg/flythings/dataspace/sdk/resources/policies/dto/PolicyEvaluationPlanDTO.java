package es.itg.flythings.dataspace.sdk.resources.policies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * Represents an evaluation plan for a Policy, including pre- and post-validation steps and the
 * evaluation flow for permissions, prohibitions, and obligations.
 *
 * <p>
 * The evaluation plan defines how each rule category is processed and validated within a given
 * policy scope or execution context.
 * </p>
 */
public class PolicyEvaluationPlanDTO {

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Object context;

    private Object preValidators;

    private Map<String, Object> permissionSteps;

    private List<Map<String, Object>> prohibitionSteps;

    private List<Map<String, Object>> obligationSteps;

    private Object postValidators;

    /**
     * Instantiates a new Policy evaluation plan dto.
     */
    public PolicyEvaluationPlanDTO() {
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
     * Gets pre validators.
     *
     * @return the pre validators
     */
    public Object getPreValidators() {
        return preValidators;
    }

    /**
     * Sets pre validators.
     *
     * @param preValidators the pre validators
     */
    public void setPreValidators(Object preValidators) {
        this.preValidators = preValidators;
    }

    /**
     * Gets permission steps.
     *
     * @return the permission steps
     */
    public Map<String, Object> getPermissionSteps() {
        return permissionSteps;
    }

    /**
     * Sets permission steps.
     *
     * @param permissionSteps the permission steps
     */
    public void setPermissionSteps(Map<String, Object> permissionSteps) {
        this.permissionSteps = permissionSteps;
    }

    /**
     * Gets prohibition steps.
     *
     * @return the prohibition steps
     */
    public List<Map<String, Object>> getProhibitionSteps() {
        return prohibitionSteps;
    }

    /**
     * Sets prohibition steps.
     *
     * @param prohibitionSteps the prohibition steps
     */
    public void setProhibitionSteps(
        List<Map<String, Object>> prohibitionSteps) {
        this.prohibitionSteps = prohibitionSteps;
    }

    /**
     * Gets obligation steps.
     *
     * @return the obligation steps
     */
    public List<Map<String, Object>> getObligationSteps() {
        return obligationSteps;
    }

    /**
     * Sets obligation steps.
     *
     * @param obligationSteps the obligation steps
     */
    public void setObligationSteps(
        List<Map<String, Object>> obligationSteps) {
        this.obligationSteps = obligationSteps;
    }

    /**
     * Gets post validators.
     *
     * @return the post validators
     */
    public Object getPostValidators() {
        return postValidators;
    }

    /**
     * Sets post validators.
     *
     * @param postValidators the post validators
     */
    public void setPostValidators(Object postValidators) {
        this.postValidators = postValidators;
    }
}
