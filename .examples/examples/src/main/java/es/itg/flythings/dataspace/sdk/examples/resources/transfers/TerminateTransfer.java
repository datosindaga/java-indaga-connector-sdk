package es.itg.flythings.dataspace.sdk.examples.resources.transfers;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.dto.TerminateTransferDTO;
import java.util.List;
import java.util.logging.Logger;

/**
 * The type Terminate transfer.
 */
public class TerminateTransfer {

    private static final Logger log = Logger.getLogger(TerminateTransfer.class.getName());

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

        var terminate = new TerminateTransferDTO();
        terminate.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        terminate.setType("TerminateTransfer");
        terminate.setReason("Transfer terminated by consumer request.");

        transfers.terminate("transfer-process-id-1", terminate);

        log.info("Terminated transfer: transfer-process-id-1");
    }
}
