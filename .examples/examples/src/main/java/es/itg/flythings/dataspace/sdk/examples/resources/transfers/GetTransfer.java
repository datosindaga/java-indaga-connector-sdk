package es.itg.flythings.dataspace.sdk.examples.resources.transfers;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
import java.util.logging.Logger;

/**
 * The type Get transfer.
 */
public class GetTransfer {

    private static final Logger log = Logger.getLogger(GetTransfer.class.getName());

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

        var transfer = transfers.getById("transfer-process-id-1");

        log.info("Got transfer: " + transfer.getId() + ", state: " + transfer.getState());
    }
}
