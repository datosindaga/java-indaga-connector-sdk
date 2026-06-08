package es.itg.flythings.dataspace.sdk.examples.resources.transfers;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.GenericDataAddressDTO;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.dto.TransferRequestDTO;
import java.util.List;
import java.util.logging.Logger;

/**
 * The type Create transfer.
 */
public class CreateTransfer {

    private static final Logger log = Logger.getLogger(CreateTransfer.class.getName());

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var transfers = client.buildClient(TransferClient.class);

        var destination = new GenericDataAddressDTO();
        destination.setType("HttpProxy");

        var transfer = new TransferRequestDTO();
        transfer.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        transfer.setType("TransferRequest");
        transfer.setCounterPartyAddress("https://provider.example.com/connector/api");
        transfer.setProtocol("dataspace-protocol-http");
        transfer.setContractId("agreement-id-1");
        transfer.setTransferType("HttpData-PULL");
        transfer.setDataDestination(destination);

        var result = transfers.create(transfer);

        log.info("Created transfer with id: " + result.getId());
    }
}
