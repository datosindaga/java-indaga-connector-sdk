package es.itg.flythings.dataspace.sdk.examples.resources.policies;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.policies.client.PolicyClient;
import java.util.logging.Logger;

/**
 * The type Validate policy.
 */
public class ValidatePolicy {

    private static final Logger log = Logger.getLogger(ValidatePolicy.class.getName());

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

        var policies = client.buildClient(PolicyClient.class);

        var result = policies.validate("policy-open-1");

        log.info("Policy valid: " + result.getValid());
    }
}
