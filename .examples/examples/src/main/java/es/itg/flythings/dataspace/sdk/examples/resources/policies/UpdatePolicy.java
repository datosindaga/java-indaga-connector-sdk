package es.itg.flythings.dataspace.sdk.examples.resources.policies;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.policies.client.PolicyClient;
import es.itg.flythings.dataspace.sdk.resources.policies.dto.PolicyDefinitionInputDTO;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The type Update policy.
 */
public class UpdatePolicy {

    private static final Logger log = Logger.getLogger(UpdatePolicy.class.getName());

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

        var policy = new PolicyDefinitionInputDTO();
        policy.setId("policy-open-1");
        policy.setPolicy(Map.of(
            "@type", "Set",
            "permission", List.of(Map.of(
                "action", "use",
                "constraint", Map.of(
                    "leftOperand", "region",
                    "operator", "eq",
                    "rightOperand", "EU"
                )
            ))
        ));

        policies.edit(policy);

        log.info("Updated policy: " + policy.getId());
    }
}
