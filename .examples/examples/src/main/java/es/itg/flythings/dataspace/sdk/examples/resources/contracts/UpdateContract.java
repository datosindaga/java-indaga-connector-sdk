package es.itg.flythings.dataspace.sdk.examples.resources.contracts;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.CriterionDTO;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.client.ContractDefinitionClient;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.dto.ContractDefinitionInputDTO;
import java.util.List;
import java.util.logging.Logger;

/**
 * The type Update contract.
 */
public class UpdateContract {

    private static final Logger log = Logger.getLogger(UpdateContract.class.getName());

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
        contract.setAccessPolicyId("policy-restricted-2");
        contract.setContractPolicyId("policy-restricted-2");
        contract.setAssetsSelector(List.of(selector));

        contracts.update(contract);

        log.info("Updated contract definition: " + contract.getId());
    }
}
