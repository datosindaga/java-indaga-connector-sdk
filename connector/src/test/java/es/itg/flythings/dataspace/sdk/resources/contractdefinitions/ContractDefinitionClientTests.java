package es.itg.flythings.dataspace.sdk.resources.contractdefinitions;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import es.itg.flythings.dataspace.sdk.config.SdkConfig;
import es.itg.flythings.dataspace.sdk.edc.dto.CriterionDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.DataAddressDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.assets.client.AssetClient;
import es.itg.flythings.dataspace.sdk.resources.assets.dto.AssetInputDTO;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.client.ContractDefinitionClient;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.dto.ContractDefinitionInputDTO;
import es.itg.flythings.dataspace.sdk.resources.policies.client.PolicyClient;
import es.itg.flythings.dataspace.sdk.resources.policies.dto.PolicyDefinitionInputDTO;
import es.itg.flythings.utils.TestConfig;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class ContractDefinitionClientTests {

    private final AssetClient assetClient;
    private final PolicyClient policyClient;
    private final ContractDefinitionClient contractDefinitionClient;

    public ContractDefinitionClientTests() {
        var config = SdkConfig.builder()
            .apiUrl(TestConfig.get("sdk.api.url"))
            .authApiUrl(TestConfig.get("sdk.auth.url"))
            .credentials(
                TestConfig.get("sdk.auth.username"),
                TestConfig.get("sdk.auth.password")
            )
            .build();
        this.assetClient = config.buildClient(AssetClient.class);
        this.policyClient = config.buildClient(PolicyClient.class);
        this.contractDefinitionClient = config.buildClient(ContractDefinitionClient.class);
    }

    @Test
    void getRequests_shouldReturnContractDefinitions_whenQueryIsValid() {
        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        var result = contractDefinitionClient.request(query);
        assertNotNull(result);
    }

    @Test
    void create_shouldReturnNewContractDefinition_whenInputIsValid() {
        var asset = new AssetInputDTO();
        asset.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        asset.setType("Asset");
        asset.setProperties(Map.of(
            "title", "Test TODO",
            "description", "Simple ToDo Json sample for testing with a simple asset",
            "keywords", List.of("Test", "TODOs"),
            "offerType", "Available",
            "publicTitle", "Test TODO",
            "publicDescription", "Simple ToDo Json sample for testing with a simple asset",
            "theme", "Testing",
            "optOut", false
        ));
        asset.setPrivateProperties(Map.of(
            "authentication", "REST-API Endpoint"
        ));
        var dataaddress = new DataAddressDTO();
        dataaddress.setType("DataAddress");
        dataaddress.setAddressType("HttpData");
        dataaddress.setBaseUrl("https://jsonplaceholder.typicode.com/todos");
        dataaddress.setAdditional(Map.of("authKey", "X-API-KEY", "authCode", "password"));
        asset.setDataAddress(dataaddress);

        var assetId = assetClient.create(asset);

        var policy = new PolicyDefinitionInputDTO();
        policy.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        policy.setType("PolicyDefinition");
        policy.setPrivateProperties(Map.of(
            "id", "require-membership-test",
            "title", "require-membership-test"
        ));
        policy.setPolicy(Map.of(
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

        var policyId = policyClient.create(policy);

        var input = new ContractDefinitionInputDTO();
        input.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        input.setType("ContractDefinition");
        input.setAccessPolicyId(policyId.getId());
        input.setContractPolicyId(policyId.getId());
        input.setPrivateProperties(Map.of(
            "title", "Test Contract",
            "description", "Test Constract"
        ));
        var assetCriterion = new CriterionDTO();
        assetCriterion.setType("Criterion");
        assetCriterion.setOperandLeft("https://w3id.org/edc/v0.0.1/ns/id");
        assetCriterion.setOperator("=");
        assetCriterion.setOperandRight(assetId.getId());
        input.setAssetsSelector(List.of(
            assetCriterion
        ));

        var contract = contractDefinitionClient.create(input);

        assertNotNull(contract);
        assertNotNull(contract.getId());

        assertDoesNotThrow(() -> contractDefinitionClient.delete(contract.getId()));
        assertDoesNotThrow(() -> assetClient.delete(assetId.getId()));
        assertDoesNotThrow(() -> policyClient.delete(policyId.getId()));

    }


}
