package es.itg.flythings.connector.resources.contractnegotiation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the current lifecycle state of a Contract Negotiation.
 *
 * <p>
 * Provides the JSON-LD context and the current negotiation state as tracked by the connector. Used
 * when querying negotiation progress or polling for updates.
 * </p>
 *
 * <h3>Negotiation States</h3>
 * <ul>
 *   <li><b>REQUESTED</b>: ContractRequest sent by the Consumer; Provider acknowledges.</li>
 *   <li><b>OFFERED</b>: Provider sends a CounterOffer to the Consumer; acknowledged.</li>
 *   <li><b>ACCEPTED</b>: Consumer accepts the Offer; Provider acknowledges.</li>
 *   <li><b>AGREED</b>: Provider confirms the Agreement; Consumer acknowledges.</li>
 *   <li><b>VERIFIED</b>: Consumer verifies the Agreement; Provider acknowledges.</li>
 *   <li><b>FINALIZED</b>: Provider finalizes the negotiation; Agreement ready.</li>
 *   <li><b>TERMINATED</b>: Negotiation ended by either party due to rejection, error, or cancellation.</li>
 * </ul>
 */
public class NegotiationStateDTO {

    @JsonProperty("@context")
    private Object context;

    private String state;

    /**
     * Instantiates a new Negotiation state dto.
     */
    public NegotiationStateDTO() {
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
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }
}
