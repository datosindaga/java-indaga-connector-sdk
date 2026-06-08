package es.itg.flythings.dataspace.sdk.examples.resources.edrs;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.edrs.client.EDRCacheClient;
import java.util.logging.Logger;

/**
 * The type Get edr address.
 */
public class GetEdrAddress {

    private static final Logger log = Logger.getLogger(GetEdrAddress.class.getName());

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

        var edrs = client.buildClient(EDRCacheClient.class);

        var address = edrs.getAddress("transfer-process-id-1");

        log.info("EDR address endpoint: " + address.getEndpoint());
    }
}
