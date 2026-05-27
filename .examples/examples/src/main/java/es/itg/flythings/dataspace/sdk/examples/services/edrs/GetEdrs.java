package es.itg.flythings.dataspace.sdk.examples.services.edrs;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.edrs.client.EDRCacheClient;
import es.itg.flythings.dataspace.sdk.services.edrs.EdrRequest;
import es.itg.flythings.dataspace.sdk.services.edrs.EdrService;
import java.util.logging.Logger;

public class GetEdrs {

    private static final Logger log = Logger.getLogger(GetEdrs.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var service = new EdrService(client.buildClient(EDRCacheClient.class));

        var results = service.getEdrs(
            new EdrRequest.Builder("a3fe7fee-b359-477c-ab9d-0f9671601bf4").build()
        );

        log.info("Found " + results.size() + " EDRs for agreement");
        results.forEach(e -> log.info("  - transferId: " + e.getTransferProcessId()));
    }
}
