package es.itg.flythings.dataspace.sdk.examples.resources.policies;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.policies.client.PolicyClient;
import es.itg.flythings.dataspace.sdk.resources.policies.dto.PolicyDefinitionInputDTO;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The type Create policy.
 */
public class CreatePolicy {

    private static final Logger log = Logger.getLogger(CreatePolicy.class.getName());

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
        policy.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        policy.setType("PolicyDefinition");
        policy.setPrivateProperties(Map.of(
            "id", "require-membership",
            "title", "Require Membership"
        ));
        policy.setPolicy(Map.of(
            "@type", "Set",
            "permission", List.of(Map.of(
                "action", "use",
                "constraint", Map.of(
                    "leftOperand", "MembershipCredential",
                    "operator", "eq",
                    "rightOperand", "active"
                )
            ))
        ));

        var result = policies.create(policy);

        log.info("Created policy with id: " + result.getId());
    }
}
