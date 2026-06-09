package es.itg.flythings.dataspace.sdk.examples.resources.transfers;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.dto.SuspendTransferDTO;
import java.util.logging.Logger;

/**
 * The type Suspend transfer.
 */
public class SuspendTransfer {

    private static final Logger log = Logger.getLogger(SuspendTransfer.class.getName());

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

        var suspend = new SuspendTransferDTO();
        suspend.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        suspend.setType("SuspendTransfer");
        suspend.setReason("Maintenance window");

        transfers.suspend("transfer-process-id-1", suspend);

        log.info("Suspended transfer: transfer-process-id-1");
    }
}
