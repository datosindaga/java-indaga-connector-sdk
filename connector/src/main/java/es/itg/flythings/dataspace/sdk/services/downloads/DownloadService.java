package es.itg.flythings.dataspace.sdk.services.downloads;

import es.itg.flythings.dataspace.sdk.config.SdkConfig;
import es.itg.flythings.dataspace.sdk.config.SdkService;
import es.itg.flythings.dataspace.sdk.edc.dto.DataAddressDTO;
import es.itg.flythings.dataspace.sdk.exceptions.SdkBadRequestException;
import es.itg.flythings.dataspace.sdk.exceptions.SdkServerException;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.clients.ContractAgreementClient;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.dto.ContractNegotiationDTO;
import es.itg.flythings.dataspace.sdk.resources.edrs.client.EDRCacheClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.dto.TransferRequestDTO;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;


/**
 * High-level service that orchestrates EDC data downloads.
 *
 * <h2>Usage with {@link SdkConfig} (recommended)</h2>
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
public final class DownloadService implements SdkService {

    private static final Logger log = Logger.getLogger(DownloadService.class.getName());

    private final ContractAgreementClient contractAgreementClient;
    private final TransferClient transferClient;
    private final EDRCacheClient edrCacheClient;

    /**
     * Creates a {@link DownloadService}, building all required clients from the provided
     * {@link SdkConfig}.
     *
     * @param config the config
     */
    public DownloadService(SdkConfig config) {
        this.contractAgreementClient = config.buildClient(ContractAgreementClient.class);
        this.transferClient = config.buildClient(TransferClient.class);
        this.edrCacheClient = config.buildClient(EDRCacheClient.class);
    }

    /**
     * Creates a {@link DownloadService} with manually provided clients. Intended for testing or
     * advanced use cases.
     *
     * @param contractAgreementClient the contract agreement client
     * @param transferClient          the transfer client
     * @param edrCacheClient          the edr cache client
     */
    public DownloadService(ContractAgreementClient contractAgreementClient,
        TransferClient transferClient,
        EDRCacheClient edrCacheClient) {
        this.contractAgreementClient = contractAgreementClient;
        this.transferClient = transferClient;
        this.edrCacheClient = edrCacheClient;
    }

    // ------------------------------------------------------------------ //
    //  Public API
    // ------------------------------------------------------------------ //

    /**
     * Executes the full download workflow for the given contract agreement.
     *
     * @param request a {@link DownloadRequest} built via {@link DownloadRequest.Builder}
     * @return a {@link DownloadResult} containing the filename and raw content bytes
     * @throws SdkBadRequestException if the contract negotiation is missing or terminated
     * @throws SdkServerException     if the download stream cannot be read
     */
    public DownloadResult download(DownloadRequest request)
        throws SdkBadRequestException, SdkServerException {
        log.info("Starting download for agreement: " + request.agreementId);

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

        // Step 3 — download
        log.fine("Downloading data via EDR cache — transferId: " + transfer.getId());
        byte[] content = fetchContent(transfer.getId());
        log.info("Download complete — transferId: " + transfer.getId()
            + ", bytes received: " + content.length);

        return new DownloadResult(content, transfer.getId());
    }

    // ------------------------------------------------------------------ //
    //  Internals
    // ------------------------------------------------------------------ //

    private byte[] fetchContent(String transferId) throws SdkServerException {
        try (feign.Response response = edrCacheClient.download(transferId);
            InputStream stream = response.body().asInputStream()) {

            log.fine("Reading response body — HTTP " + response.status());
            return stream.readAllBytes();

        } catch (IOException e) {
            throw new SdkServerException(
                "Failed to read download response for transfer: " + transferId
            );
        }
    }

    private TransferRequestDTO buildTransferRequest(ContractNegotiationDTO negotiation,
        DownloadRequest request) {
        var address = new DataAddressDTO();
        address.setAddressType(request.dataAddressType);

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
