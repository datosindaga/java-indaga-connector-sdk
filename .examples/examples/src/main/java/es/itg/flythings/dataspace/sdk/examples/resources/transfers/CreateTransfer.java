package es.itg.flythings.dataspace.sdk.examples.resources.transfers;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.GenericDataAddressDTO;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.dto.TransferRequestDTO;
import java.util.logging.Logger;

public class CreateTransfer {

    private static final Logger log = Logger.getLogger(CreateTransfer.class.getName());

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
        transfer.setCounterPartyAddress("https://provider.example.com/connector/api");
        transfer.setProtocol("dataspace-protocol-http");
        transfer.setContractId("agreement-id-1");
        transfer.setTransferType("HttpData-PULL");
        transfer.setDataDestination(destination);

        var result = transfers.create(transfer);

        log.info("Created transfer with id: " + result.getId());
    }
}
