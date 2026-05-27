package es.itg.flythings.dataspace.sdk.examples.resources.policies;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.policies.client.PolicyClient;
import java.util.logging.Logger;

public class GetPolicy {

    private static final Logger log = Logger.getLogger(GetPolicy.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var policies = client.buildClient(PolicyClient.class);

        var policy = policies.getById("policy-open-1");

        log.info("Got policy: " + policy.getId());
    }
}
