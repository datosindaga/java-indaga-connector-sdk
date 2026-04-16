package es.itg.flythings.dataspace.sdk.resources.transfers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.itg.flythings.dataspace.sdk.edc.dto.CallbackAddressDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.DataAddressDTO;
import java.util.List;
import java.util.Map;

/**
 * Request to initiate a data transfer between Participants.
 *
 * <p>
 * Specifies the counter-party endpoint and protocol, the contract to use, the destination where
 * data should be written, and optional callback addresses.
 * </p>
 */
public class TransferRequestDTO {

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Object context;

    private String counterPartyAddress;

    private String protocol;

    private String contractId;

    private String transferType;

    private Map<String, Object> privateProperties;

    private DataAddressDTO dataDestination;

    private List<CallbackAddressDTO> callbackAddresses;

    /**
     * Instantiates a new Transfer request dto.
     */
    public TransferRequestDTO() {
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
     * Gets contract id.
     *
     * @return the contract id
     */
    public String getContractId() {
        return contractId;
    }

    /**
     * Sets contract id.
     *
     * @param contractId the contract id
     */
    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    /**
     * Gets transfer type.
     *
     * @return the transfer type
     */
    public String getTransferType() {
        return transferType;
    }

    /**
     * Sets transfer type.
     *
     * @param transferType the transfer type
     */
    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    /**
     * Gets private properties.
     *
     * @return the private properties
     */
    public Map<String, Object> getPrivateProperties() {
        return privateProperties;
    }

    /**
     * Sets private properties.
     *
     * @param privateProperties the private properties
     */
    public void setPrivateProperties(Map<String, Object> privateProperties) {
        this.privateProperties = privateProperties;
    }

    /**
     * Gets data destination.
     *
     * @return the data destination
     */
    public DataAddressDTO getDataDestination() {
        return dataDestination;
    }

    /**
     * Sets data destination.
     *
     * @param dataDestination the data destination
     */
    public void setDataDestination(DataAddressDTO dataDestination) {
        this.dataDestination = dataDestination;
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
}
