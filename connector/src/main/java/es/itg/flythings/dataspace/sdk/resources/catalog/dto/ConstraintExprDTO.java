package es.itg.flythings.dataspace.sdk.resources.catalog.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

/**
 * The type Constraint expr dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConstraintExprDTO {

    private List<Object> or;

    private List<Object> andSequence;

    private List<Object> and;

    private List<Object> xone;

    // ----- Atomic constraint properties -----

    @JsonProperty("odrl:leftOperand")
    @JsonAlias({"leftOperand"})
    private TermRef leftOperand;

    @JsonProperty("odrl:operator")
    @JsonAlias({"operator"})
    private TermRef operator;

    @JsonProperty("odrl:rightOperand")
    @JsonAlias({"rightOperand"})
    private JsonNode rightOperand;

    /**
     * Instantiates a new Constraint expr dto.
     */
    public ConstraintExprDTO() {
    }

    /**
     * Gets or.
     *
     * @return the or
     */
    public List<Object> getOr() {
        return or;
    }

    /**
     * Sets or.
     *
     * @param or the or
     */
    public void setOr(List<Object> or) {
        this.or = or;
    }

    /**
     * Gets and sequence.
     *
     * @return the and sequence
     */
    public List<Object> getAndSequence() {
        return andSequence;
    }

    /**
     * Sets and sequence.
     *
     * @param andSequence the and sequence
     */
    public void setAndSequence(List<Object> andSequence) {
        this.andSequence = andSequence;
    }

    /**
     * Gets and.
     *
     * @return the and
     */
    public List<Object> getAnd() {
        return and;
    }

    /**
     * Sets and.
     *
     * @param and the and
     */
    public void setAnd(List<Object> and) {
        this.and = and;
    }

    /**
     * Gets xone.
     *
     * @return the xone
     */
    public List<Object> getXone() {
        return xone;
    }

    /**
     * Sets xone.
     *
     * @param xone the xone
     */
    public void setXone(List<Object> xone) {
        this.xone = xone;
    }

    /**
     * Gets left operand.
     *
     * @return the left operand
     */
    public TermRef getLeftOperand() {
        return leftOperand;
    }

    /**
     * Sets left operand.
     *
     * @param leftOperand the left operand
     */
    public void setLeftOperand(TermRef leftOperand) {
        this.leftOperand = leftOperand;
    }

    /**
     * Gets operator.
     *
     * @return the operator
     */
    public TermRef getOperator() {
        return operator;
    }

    /**
     * Sets operator.
     *
     * @param operator the operator
     */
    public void setOperator(TermRef operator) {
        this.operator = operator;
    }

    /**
     * Gets right operand.
     *
     * @return the right operand
     */
    public JsonNode getRightOperand() {
        return rightOperand;
    }

    /**
     * Sets right operand.
     *
     * @param rightOperand the right operand
     */
    public void setRightOperand(JsonNode rightOperand) {
        this.rightOperand = rightOperand;
    }
}
