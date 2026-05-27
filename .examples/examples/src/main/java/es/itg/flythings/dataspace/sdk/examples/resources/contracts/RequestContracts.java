package es.itg.flythings.dataspace.sdk.examples.resources.contracts;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.client.ContractDefinitionClient;
import java.util.logging.Logger;

public class RequestContracts {

    private static final Logger log = Logger.getLogger(RequestContracts.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var contracts = client.buildClient(ContractDefinitionClient.class);

        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setOffset(0);
        query.setLimit(50);

        var results = contracts.request(query);

        log.info("Found " + results.size() + " contract definitions");
        results.forEach(c -> log.info("  - " + c.getId()));
    }
}
