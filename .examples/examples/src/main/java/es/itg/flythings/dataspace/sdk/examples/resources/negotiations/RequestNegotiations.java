package es.itg.flythings.dataspace.sdk.examples.resources.negotiations;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.client.ContractNegotiationClient;
import java.util.logging.Logger;

/**
 * The type Request negotiations.
 */
public class RequestNegotiations {

    private static final Logger log = Logger.getLogger(RequestNegotiations.class.getName());

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

        var negotiations = client.buildClient(ContractNegotiationClient.class);

        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setOffset(0);
        query.setLimit(50);

        var results = negotiations.request(query);

        log.info("Found " + results.size() + " negotiations");
        results.forEach(n -> log.info("  - " + n.getId() + " [" + n.getState() + "]"));
    }
}
