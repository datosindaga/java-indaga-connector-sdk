package es.itg.flythings.dataspace.sdk.resources.policies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents the result of validating an ODRL Policy.
 *
 * <p>
 * Contains information about the validation outcome, including whether the policy is valid and a
 * list of any detected errors or inconsistencies. Includes JSON-LD metadata to maintain
 * compatibility with dataspace policy exchange formats.
 * </p>
 */
public class PolicyValidationResultDTO {

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Object context = new HashMap<>();

    private Boolean isValid;

    private List<String> errors = new ArrayList<>();

    /**
     * Instantiates a new Policy validation result dto.
     */
    public PolicyValidationResultDTO() {
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
     * Gets valid.
     *
     * @return the valid
     */
    public Boolean getValid() {
        return isValid;
    }

    /**
     * Sets valid.
     *
     * @param valid the valid
     */
    public void setValid(Boolean valid) {
        isValid = valid;
    }

    /**
     * Gets errors.
     *
     * @return the errors
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * Sets errors.
     *
     * @param errors the errors
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
