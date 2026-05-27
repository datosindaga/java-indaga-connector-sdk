package es.itg.flythings.dataspace.sdk.examples.services.transfer;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.exceptions.SdkBadRequestException;
import es.itg.flythings.dataspace.sdk.exceptions.SdkServerException;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.clients.ContractAgreementClient;
import es.itg.flythings.dataspace.sdk.resources.edrs.client.EDRCacheClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
import es.itg.flythings.dataspace.sdk.services.transfers.TransferRequest;
import es.itg.flythings.dataspace.sdk.services.transfers.TransferService;
import java.util.logging.Logger;

public class StartTransfer {

    private static final Logger log = Logger.getLogger(StartTransfer.class.getName());

    public static void main(String[] args) throws SdkBadRequestException, SdkServerException {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var service = new TransferService(
            client.buildClient(ContractAgreementClient.class),
            client.buildClient(TransferClient.class),
            client.buildClient(EDRCacheClient.class)
        );

        var transfer = service.startTransfer(
            new TransferRequest.Builder("a3fe7fee-b359-477c-ab9d-0f9671601bf4").build()
        );

        log.info("Transfer started: " + transfer.getId() + ", state: " + transfer.getState());
    }
}
