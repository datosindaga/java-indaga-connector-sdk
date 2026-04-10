package es.itg.flythings.dataspace.sdk.resources.policies;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import es.itg.flythings.dataspace.sdk.config.SdkConfig;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.policies.client.PolicyClient;
import es.itg.flythings.dataspace.sdk.resources.policies.dto.PolicyDefinitionInputDTO;
import es.itg.flythings.utils.TestConfig;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PolicyClientTests {

    private final PolicyClient policyClient;

    public PolicyClientTests() {
        var config = SdkConfig.builder()
            .apiUrl(TestConfig.get("sdk.api.url"))
            .authApiUrl(TestConfig.get("sdk.auth.url"))
            .credentials(
                TestConfig.get("sdk.auth.username"),
                TestConfig.get("sdk.auth.password")
            )
            .build();
        this.policyClient = config.buildClient(PolicyClient.class);
    }

    @Test
    void getRequests_shouldReturnPolicies_whenQueryIsValid() {
        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        var result = policyClient.request(query);
        assertNotNull(result);
    }


    @Test
    void create_shouldReturnNewPolicy_whenInputIsValid() {
        var input = new PolicyDefinitionInputDTO();
        input.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        input.setType("PolicyDefinition");
        input.setPrivateProperties(Map.of(
            "id", "require-membership-test",
            "title", "require-membership-test"
        ));
        input.setPolicy(Map.of(
            "@type", "Set",
            "permission", List.of(
                Map.of(
                    "action", "use",
                    "constraint", Map.of(
                        "leftOperand", "MembershipCredential",
                        "operator", "eq",
                        "rightOperand", "active"
                    )
                )
            )
        ));

        var id = policyClient.create(input);
        assertNotNull(id);
        assertNotNull(id.getId());

        assertDoesNotThrow(() -> policyClient.getById(id.getId()));

        assertDoesNotThrow(() -> policyClient.delete(id.getId()));
    }


}
