package es.itg.flythings.dataspace.sdk.examples.resources.contracts;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.CriterionDTO;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.client.ContractDefinitionClient;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.dto.ContractDefinitionInputDTO;
import java.util.List;
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
        selector.setOperandLeft("id");
        selector.setOperator("=");
        selector.setOperandRight("asset-todo-api-1");

        var contract = new ContractDefinitionInputDTO();
        contract.setId("contract-def-1");
        contract.setAccessPolicyId("policy-open-1");
        contract.setContractPolicyId("policy-open-1");
        contract.setAssetsSelector(List.of(selector));

        var result = contracts.create(contract);

        log.info("Created contract definition with id: " + result.getId());
    }
}
