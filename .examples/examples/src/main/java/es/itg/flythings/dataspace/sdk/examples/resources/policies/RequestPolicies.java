package es.itg.flythings.dataspace.sdk.examples.resources.policies;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.policies.client.PolicyClient;
import java.util.logging.Logger;

public class RequestPolicies {

    private static final Logger log = Logger.getLogger(RequestPolicies.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var policies = client.buildClient(PolicyClient.class);

        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setOffset(0);
        query.setLimit(50);

        var results = policies.request(query);

        log.info("Found " + results.size() + " policies");
        results.forEach(p -> log.info("  - " + p.getId()));
    }
}
