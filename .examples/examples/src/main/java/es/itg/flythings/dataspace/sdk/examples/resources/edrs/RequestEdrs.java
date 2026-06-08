package es.itg.flythings.dataspace.sdk.examples.resources.edrs;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.edrs.client.EDRCacheClient;
import java.util.List;
import java.util.logging.Logger;

/**
 * The type Request edrs.
 */
public class RequestEdrs {

    private static final Logger log = Logger.getLogger(RequestEdrs.class.getName());

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

        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        query.setOffset(0);
        query.setLimit(50);

        var results = edrs.request(query);

        log.info("Found " + results.size() + " EDRs");
        results.forEach(e -> log.info("  - " + e.getId()));
    }
}
