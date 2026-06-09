package es.itg.flythings.dataspace.sdk.examples.resources.contracts;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.client.ContractDefinitionClient;
import java.util.List;
import java.util.logging.Logger;

/**
 * The type Request contracts.
 */
public class RequestContracts {

    private static final Logger log = Logger.getLogger(RequestContracts.class.getName());

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

        var contracts = client.buildClient(ContractDefinitionClient.class);

        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        query.setOffset(0);
        query.setLimit(50);

        var results = contracts.request(query);

        log.info("Found " + results.getItems().size() + " contract definitions");
        log.info("Has more: " + results.getHasMore());
        results.getItems().forEach(c -> log.info("  - " + c.getId()));
    }
}
