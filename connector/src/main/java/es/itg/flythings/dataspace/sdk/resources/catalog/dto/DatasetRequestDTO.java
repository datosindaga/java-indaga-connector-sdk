package es.itg.flythings.dataspace.sdk.resources.catalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;

/**
 * Request object used to query available datasets from a counter-party connector.
 *
 * <p>
 * Includes protocol, counter-party details, and an optional QuerySpec for filtering results.
 * </p>
 */
public class DatasetRequestDTO {

    @JsonProperty("@context")
    private Object context;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@id")
    private String id;

    private String protocol;

    private String counterPartyAddress;

    private String counterPartyId;

    private QuerySpecDTO querySpec;

    /**
     * Instantiates a new Dataset request dto.
     */
    public DatasetRequestDTO() {
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
     * Gets protocol.
     *
     * @return the protocol
     */
    public String getProtocol() {
        return protocol;
    }

    /**
     * Sets protocol.
     *
     * @param protocol the protocol
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * Gets counter party address.
     *
     * @return the counter party address
     */
    public String getCounterPartyAddress() {
        return counterPartyAddress;
    }

    /**
     * Sets counter party address.
     *
     * @param counterPartyAddress the counter party address
     */
    public void setCounterPartyAddress(String counterPartyAddress) {
        this.counterPartyAddress = counterPartyAddress;
    }

    /**
     * Gets counter party id.
     *
     * @return the counter party id
     */
    public String getCounterPartyId() {
        return counterPartyId;
    }

    /**
     * Sets counter party id.
     *
     * @param counterPartyId the counter party id
     */
    public void setCounterPartyId(String counterPartyId) {
        this.counterPartyId = counterPartyId;
    }

    /**
     * Gets query spec.
     *
     * @return the query spec
     */
    public QuerySpecDTO getQuerySpec() {
        return querySpec;
    }

    /**
     * Sets query spec.
     *
     * @param querySpec the query spec
     */
    public void setQuerySpec(QuerySpecDTO querySpec) {
        this.querySpec = querySpec;
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
}
