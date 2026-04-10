package es.itg.flythings.dataspace.sdk.resources.catalog.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents a single ODRL rule (permission, prohibition, or obligation).
 *
 * <p>
 * Each rule defines an action (e.g., "use", "read") and optional constraints that restrict when or
 * how the rule applies.
 * </p>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyRuleDTO {

    @JsonProperty("odrl:action")
    @JsonAlias({"action"})
    private TermRef action;

    @JsonProperty("odrl:constraint")
    @JsonAlias({"constraint"})
    private List<ConstraintExprDTO> constraint;

    /**
     * Instantiates a new Policy rule dto.
     */
    public PolicyRuleDTO() {
    }

    /**
     * Gets action.
     *
     * @return the action
     */
    public TermRef getAction() {
        return action;
    }

    /**
     * Sets action.
     *
     * @param action the action
     */
    public void setAction(TermRef action) {
        this.action = action;
    }

    /**
     * Gets constraint.
     *
     * @return the constraint
     */
    public List<ConstraintExprDTO> getConstraint() {
        return constraint;
    }

    /**
     * Sets constraint.
     *
     * @param constraint the constraint
     */
    public void setConstraint(
        List<ConstraintExprDTO> constraint) {
        this.constraint = constraint;
    }
}


