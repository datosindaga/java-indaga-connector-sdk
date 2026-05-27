package es.itg.flythings.dataspace.sdk.examples.resources.agreements;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.clients.ContractAgreementClient;
import java.util.logging.Logger;

public class RequestAgreements {

    private static final Logger log = Logger.getLogger(RequestAgreements.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var agreements = client.buildClient(ContractAgreementClient.class);

        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setOffset(0);
        query.setLimit(50);

        var results = agreements.request(query);

        log.info("Found " + results.size() + " contract agreements");
        results.forEach(a -> log.info("  - " + a.getId()));
    }
}
