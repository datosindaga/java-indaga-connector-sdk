package es.itg.flythings.connector.resources.contractnegotiation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.itg.flythings.dataspace.edc.dto.CallbackAddressDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a Contract Request sent by a Consumer to initiate a Contract Negotiation.
 *
 * <p>
 * Defines the target counter-party, the negotiation protocol, the policy offer, and optional
 * callback configuration for receiving negotiation events.
 * </p>
 */
public class ContractRequestDTO {

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Object context;

    private List<CallbackAddressDTO> callbackAddresses;

    private String counterPartyAddress;

    private OfferDTO policy;

    private String protocol;

    private Map<String, Object> privateProperties = new HashMap<>();

    /**
     * Instantiates a new Contract request dto.
     */
    public ContractRequestDTO() {
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
     * Gets callback addresses.
     *
     * @return the callback addresses
     */
    public List<CallbackAddressDTO> getCallbackAddresses() {
        return callbackAddresses;
    }

    /**
     * Sets callback addresses.
     *
     * @param callbackAddresses the callback addresses
     */
    public void setCallbackAddresses(
        List<CallbackAddressDTO> callbackAddresses) {
        this.callbackAddresses = callbackAddresses;
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
     * Gets policy.
     *
     * @return the policy
     */
    public OfferDTO getPolicy() {
        return policy;
    }

    /**
     * Sets policy.
     *
     * @param policy the policy
     */
    public void setPolicy(OfferDTO policy) {
        this.policy = policy;
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

    public Map<String, Object> getPrivateProperties() {
        return privateProperties;
    }

    public void setPrivateProperties(Map<String, Object> privateProperties) {
        this.privateProperties = privateProperties;
    }
}
