package es.itg.flythings.dataspace.sdk.examples.resources.contracts;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.client.ContractDefinitionClient;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.enums.ContractState;
import java.util.logging.Logger;

/**
 * The type Change state contract.
 */
public class ChangeStateContract {

    private static final Logger log = Logger.getLogger(ChangeStateContract.class.getName());

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

        contracts.changeState("contract-def-1", ContractState.UNDER_REVIEW.name());

        log.info("Changed state of contract definition contract-def-1 to PUBLISHED");
    }
}
