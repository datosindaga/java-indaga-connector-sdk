package es.itg.flythings.dataspace.sdk.edc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a single filtering condition within a {@link QuerySpecDTO}.
 *
 * <p>Each criterion defines a left operand, an operator, and a right operand. Criteria are
 * combined using logical AND semantics to filter query results.</p>
 *
 * <p>For example:</p>
 * <pre>{@code
 * { "operandLeft": "properties.contentType", "operator": "=", "operandRight": "application/json" }
 * }*</pre>
 */
public class CriterionDTO {

    /**
     * JSON-LD type of the criterion object, typically set to {@code Criterion}.
     */
    @JsonProperty("@type")
    private String type;

    /**
     * The left operand of the expression — usually a property name or path. Can reference metadata
     * fields (e.g., {@code properties.contentType}) or nested attributes.
     */
    private String operandLeft;

    /**
     * The right operand of the expression — the value or constant to compare against. Accepts
     * string, numeric, or boolean values depending on the target property.
     */
    private Object operandRight;

    /**
     * The operator applied between the left and right operands.
     *
     * <p>Common operators include:</p>
     * <ul>
     *   <li>{@code =} — equal</li>
     *   <li>{@code !=} — not equal</li>
     *   <li>{@code >} — greater than</li>
     *   <li>{@code <} — less than</li>
     *   <li>{@code in} — membership check</li>
     * </ul>
     */
    private String operator;

    /**
     * Instantiates a new Criterion dto.
     */
    public CriterionDTO() {
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
     * Gets operand left.
     *
     * @return the operand left
     */
    public String getOperandLeft() {
        return operandLeft;
    }

    /**
     * Sets operand left.
     *
     * @param operandLeft the operand left
     */
    public void setOperandLeft(String operandLeft) {
        this.operandLeft = operandLeft;
    }

    /**
     * Gets operand right.
     *
     * @return the operand right
     */
    public Object getOperandRight() {
        return operandRight;
    }


    /**
     * Sets operand right.
     *
     * @param operandRight the operand right
     */
    public void setOperandRight(Object operandRight) {
        this.operandRight = operandRight;
    }

    /**
     * Gets operator.
     *
     * @return the operator
     */
    public String getOperator() {
        return operator;
    }

    /**
     * Sets operator.
     *
     * @param operator the operator
     */
    public void setOperator(String operator) {
        this.operator = operator;
    }
}
