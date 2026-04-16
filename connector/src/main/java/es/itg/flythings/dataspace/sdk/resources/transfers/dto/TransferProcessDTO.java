package es.itg.flythings.dataspace.sdk.resources.transfers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.itg.flythings.dataspace.sdk.edc.dto.CallbackAddressDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.DataAddressDTO;
import es.itg.flythings.dataspace.sdk.resources.transfers.enums.TransferProcessRole;
import es.itg.flythings.dataspace.sdk.resources.transfers.enums.TransferStateEnum;
import java.util.List;

/**
 * Represents a transfer process as tracked by the connector.
 *
 * <p>
 * Includes identity, role (Consumer/Provider), current lifecycle state, timestamps, correlation
 * identifiers, and destination configuration.
 * </p>
 */
public class TransferProcessDTO {

    @JsonProperty("@context")
    private Object context;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@id")
    private String id;

    @JsonProperty("type")
    private TransferProcessRole role;

    private TransferStateEnum state;

    private Long stateTimestamp;

    private List<CallbackAddressDTO> callbackAddresses;

    private String correlationId;

    private String assetId;

    private String contractId;

    private String transferType;

    private String errorDetail;

    private DataAddressDTO dataDestination;

    /**
     * Instantiates a new Transfer process dto.
     */
    public TransferProcessDTO() {

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
     * Gets role.
     *
     * @return the role
     */
    public TransferProcessRole getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(TransferProcessRole role) {
        this.role = role;
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

    /**
     * Gets state timestamp.
     *
     * @return the state timestamp
     */
    public Long getStateTimestamp() {
        return stateTimestamp;
    }

    /**
     * Sets state timestamp.
     *
     * @param stateTimestamp the state timestamp
     */
    public void setStateTimestamp(Long stateTimestamp) {
        this.stateTimestamp = stateTimestamp;
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
     * Gets correlation id.
     *
     * @return the correlation id
     */
    public String getCorrelationId() {
        return correlationId;
    }

    /**
     * Sets correlation id.
     *
     * @param correlationId the correlation id
     */
    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    /**
     * Gets asset id.
     *
     * @return the asset id
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
}
