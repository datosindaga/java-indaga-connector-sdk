package es.itg.flythings.connector.resources.transfers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.itg.flythings.connector.resources.transfers.enums.TransferStateEnum;

/**
 * Represents the current lifecycle state of a data transfer.
 *
 * <p>
 * Changes are <b>asynchronous</b>. For example, a transfer may remain in
 * <i>REQUESTED</i> while the Provider prepares the dataset before moving to <i>STARTED</i>.
 * </p>
 *
 * <p>
 * <b>Finite vs. Non-Finite:</b> Finite transfers (e.g., a fixed set of files) typically
 * reach <i>COMPLETED</i>. Non-finite/streaming transfers (e.g., HTTP streams) may stay
 * <i>STARTED</i> until they are explicitly <i>TERMINATED</i>.
 * </p>
 */
public class TransferStateDTO {

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Object context;

    private TransferStateEnum state;

    /**
     * Instantiates a new Transfer state dto.
     */
    public TransferStateDTO() {
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
     * Gets state.
     *
     * @return the state
     */
    public TransferStateEnum getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(TransferStateEnum state) {
        this.state = state;
    }
}
