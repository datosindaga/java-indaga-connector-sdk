package es.itg.flythings.connector.resources.contractnegotiation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.itg.flythings.dataspace.edc.dto.CallbackAddressDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a Contract Negotiation process between two Participants.
 *
 * <p>
 * Describes the lifecycle of the negotiation and metadata exchanged between consumer and provider
 * connectors, including callbacks, counter-party details, and the resulting agreement when
 * completed.
 * </p>
 *
 * <h3>Contract Negotiation Lifecycle</h3>
 *
 * <pre>
 *  [*] --> Requested: Consumer sends ContractRequest
 *  Requested --> Offered: Provider sends CounterOffer
 *  Offered --> Accepted: Consumer accepts
 *  Accepted --> Agreed: Provider confirms Agreement
 *  Agreed --> Verified: Consumer verifies
 *  Verified --> Finalized: Provider finalizes (Contract Agreement ready)
 *
 *  Requested --> Terminated: Rejected / Error
 *  Offered --> Terminated: Rejected / Error
 *  Accepted --> Terminated: Agreement unsatisfied / Error
 *  Agreed --> Terminated: Agreement verification failed / Error
 *  Verified --> Terminated: Rejected / Error
 *  Finalized --> Terminated: Cancelled / Error / Expired
 *
 *  Finalized --> [*]
 * </pre>
 *
 * <h3>State Descriptions</h3>
 * <ul>
 *   <li><b>Requested</b>: Consumer sends a ContractRequest for an Asset. Provider acknowledges.</li>
 *   <li><b>Offered</b>: Provider sends a CounterOffer to the Consumer, who acknowledges.</li>
 *   <li><b>Accepted</b>: Consumer accepts the last Offer; Provider acknowledges.</li>
 *   <li><b>Agreed</b>: Provider accepts the Offer, sends an Agreement to the Consumer, who acknowledges.</li>
 *   <li><b>Verified</b>: Consumer verifies the Agreement; Provider acknowledges.</li>
 *   <li><b>Finalized</b>: Provider finalizes the negotiation; the Contract Agreement is ready and acknowledged by the Consumer.</li>
 *   <li><b>Terminated</b>: Either party ends the negotiation due to rejection, error, or cancellation. This is a terminal state.</li>
 * </ul>
 */
public class ContractNegotiationDTO {

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@context")
    private Object context;

    private List<CallbackAddressDTO> callbackAddresses;

    private String contractAgreementId;

    private String counterPartyAddress;

    private String counterPartyId;

    private String errorDetail;

    private String protocol;

    private String state;

    @JsonProperty("type")
    private String typeRole;

    @JsonProperty("assetId")
    private String assetId;

    private Map<String, Object> privateProperties = new HashMap<>();

    private Long createdAt;

    /**
     * Instantiates a new Contract negotiation dto.
     */
    public ContractNegotiationDTO() {
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
     * Gets contract agreement id.
     *
     * @return the contract agreement id
     */
    public String getContractAgreementId() {
        return contractAgreementId;
    }

    /**
     * Sets contract agreement id.
     *
     * @param contractAgreementId the contract agreement id
     */
    public void setContractAgreementId(String contractAgreementId) {
        this.contractAgreementId = contractAgreementId;
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
     * Gets error detail.
     *
     * @return the error detail
     */
    public String getErrorDetail() {
        return errorDetail;
    }

    /**
     * Sets error detail.
     *
     * @param errorDetail the error detail
     */
    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
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

    /**
     * Gets type role.
     *
     * @return the type role
     */
    public String getTypeRole() {
        return typeRole;
    }

    /**
     * Sets type role.
     *
     * @param typeRole the type role
     */
    public void setTypeRole(String typeRole) {
        this.typeRole = typeRole;
    }

    /**
     * Gets asset id.
     *
     * @return asset id
     */
    public String getAssetId() {
        return assetId;
    }

    /**
     * Sets asset id.
     *
     * @param assetId the asset id
     */
    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    /**
     * Gets created at.
     *
     * @return the created at
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }


    public Map<String, Object> getPrivateProperties() {
        return privateProperties;
    }

    public void setPrivateProperties(Map<String, Object> privateProperties) {
        this.privateProperties = privateProperties;
    }
}
