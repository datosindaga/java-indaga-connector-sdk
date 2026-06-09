package es.itg.flythings.dataspace.sdk.examples.resources.contracts;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.CriterionDTO;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.client.ContractDefinitionClient;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.dto.ContractDefinitionInputDTO;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The type Create contract.
 */
public class CreateContract {

    private static final Logger log = Logger.getLogger(CreateContract.class.getName());

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

        var selector = new CriterionDTO();
        selector.setType("Criterion");
        selector.setOperandLeft("https://w3id.org/edc/v0.0.1/ns/id");
        selector.setOperator("=");
        selector.setOperandRight("asset-todo-api-1");

        var contract = new ContractDefinitionInputDTO();
        contract.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        contract.setType("ContractDefinition");
        contract.setAccessPolicyId("policy-open-1");
        contract.setContractPolicyId("policy-open-1");
        contract.setAssetsSelector(List.of(selector));
        contract.setPrivateProperties(Map.of(
            "title", "Example", "description", "Example Contract"
        ));

        var result = contracts.create(contract);

        log.info("Created contract definition with id: " + result.getId());
    }
}
