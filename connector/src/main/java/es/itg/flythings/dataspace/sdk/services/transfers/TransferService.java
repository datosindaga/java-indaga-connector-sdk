package es.itg.flythings.dataspace.sdk.services.transfers;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.GenericDataAddressDTO;
import es.itg.flythings.dataspace.sdk.exceptions.SdkBadRequestException;
import es.itg.flythings.dataspace.sdk.exceptions.SdkServerException;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.clients.ContractAgreementClient;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.dto.ContractNegotiationDTO;
import es.itg.flythings.dataspace.sdk.resources.edrs.client.EDRCacheClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.dto.TransferProcessDTO;
import es.itg.flythings.dataspace.sdk.resources.transfers.dto.TransferRequestDTO;
import es.itg.flythings.dataspace.sdk.services.downloads.DownloadRequest;
import java.util.logging.Logger;


/**
 * High-level service that orchestrates EDC data downloads.
 *
 * <h2>Usage with {@link DataspaceClient} (recommended)</h2>
 * <pre>{@code
 * var service = new DownloadService(config);
 *
 * DownloadResult result = service.download(
 *         new DownloadRequest.Builder("my-agreement-id").build()
 * );
 * }*</pre>
 *
 * <h2>With custom transfer configuration</h2>
 * <pre>{@code
 * DownloadResult result = service.download(
 *         new DownloadRequest.Builder("my-agreement-id")
 *                 .transferType("HttpData-PUSH")
 *                 .dataAddressType("AmazonS3")
 *                 .build()
 * );
 * }*</pre>
 *
 * <h2>Usage with manual clients (testing)</h2>
 * <pre>{@code
 * var service = new DownloadService(
 *         contractAgreementClient,
 *         transferClient,
 *         edrCacheClient
 * );
 * }*</pre>
 */
public final class TransferService {

    private static final Logger log = Logger.getLogger(TransferService.class.getName());

    private final ContractAgreementClient contractAgreementClient;
    private final TransferClient transferClient;

    /**
     * Creates a {@link TransferService}, building all required clients from the provided
     * {@link DataspaceClient}.
     *
     * @param config the config
     */
    public TransferService(DataspaceClient config) {
        this.contractAgreementClient = config.buildClient(ContractAgreementClient.class);
        this.transferClient = config.buildClient(TransferClient.class);
    }

    /**
     * Creates a {@link TransferService} with manually provided clients. Intended for testing or
     * advanced use cases.
     *
     * @param contractAgreementClient the contract agreement client
     * @param transferClient          the transfer client
     * @param edrCacheClient          the edr cache client
     */
    public TransferService(ContractAgreementClient contractAgreementClient,
        TransferClient transferClient,
        EDRCacheClient edrCacheClient) {
        this.contractAgreementClient = contractAgreementClient;
        this.transferClient = transferClient;
    }

    // ------------------------------------------------------------------ //
    //  Public API
    // ------------------------------------------------------------------ //

    /**
     * Executes the transfer workflow for the given contract agreement.
     *
     * @param request a {@link DownloadRequest} built via {@link DownloadRequest.Builder}
     * @return a {@link TransferProcessDTO} containing the transfer data
     * @throws SdkBadRequestException if the contract negotiation is missing or terminated
     * @throws SdkServerException     if the download stream cannot be read
     */
    public TransferProcessDTO startTransfer(TransferRequest request)
        throws SdkBadRequestException, SdkServerException {
        log.info("Starting transfer for agreement: " + request.agreementId);

        // Step 1 — resolve negotiation
        log.fine("Fetching contract negotiation...");
        var negotiation = contractAgreementClient.getNegotiationByAgreementId(request.agreementId);

        if (negotiation == null) {
            throw new SdkBadRequestException(
                "No negotiation found for agreement: " + request.agreementId
            );
        }
        if ("TERMINATED".equals(negotiation.getState())) {
            throw new SdkBadRequestException(
                "Contract negotiation is TERMINATED for agreement: " + request.agreementId
            );
        }
        log.info("Negotiation resolved — state: " + negotiation.getState()
            + ", counterParty: " + negotiation.getCounterPartyAddress());

        // Step 2 — initiate transfer
        log.fine("Initiating transfer process...");
        var transfer = transferClient.create(buildTransferRequest(negotiation, request));
        log.info("Transfer process created — id: " + transfer.getId()
            + ", type: " + request.transferType);

        return transferClient.getById(transfer.getId());
    }

    // ------------------------------------------------------------------ //
    //  Internals
    // ------------------------------------------------------------------ //

    private TransferRequestDTO buildTransferRequest(ContractNegotiationDTO negotiation,
        TransferRequest request) {
        var address = new GenericDataAddressDTO();
        address.setType(request.dataAddressType);

        var transfer = new TransferRequestDTO();
        transfer.setContext(request.context);
        transfer.setProtocol(request.protocol);
        transfer.setTransferType(request.transferType);
        transfer.setDataDestination(address);
        transfer.setContractId(negotiation.getContractAgreementId());
        transfer.setCounterPartyAddress(negotiation.getCounterPartyAddress());
        return transfer;
    }

}
