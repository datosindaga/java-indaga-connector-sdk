package es.itg.flythings.dataspace.sdk.resources.transfers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a request to suspend an ongoing data transfer process.
 *
 * <p>
 * This DTO is used when a participant or the connector itself needs to temporarily halt a transfer.
 * A reason may be provided for traceability or auditing purposes.
 * </p>
 */
public class SuspendTransferDTO {

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Object context;

    private String reason;

    /**
     * Instantiates a new Suspend transfer dto.
     */
    public SuspendTransferDTO() {
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
