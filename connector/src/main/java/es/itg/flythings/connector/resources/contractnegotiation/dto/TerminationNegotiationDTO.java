package es.itg.flythings.connector.resources.contractnegotiation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a request to terminate an ongoing Contract Negotiation.
 *
 * <p>
 * Either participant (Consumer or Provider) may send this request to end the negotiation process
 * due to rejection, error, or cancellation. A textual reason may be provided for audit or
 * traceability purposes.
 * </p>
 */
public class TerminationNegotiationDTO {

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Object context;

    private String reason;

    /**
     * Instantiates a new Termination negotiation dto.
     */
    public TerminationNegotiationDTO() {
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
     * Gets reason.
     *
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * Sets reason.
     *
     * @param reason the reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }
}
