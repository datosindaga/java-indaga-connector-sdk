package es.itg.flythings.dataspace.sdk.examples.resources.contracts;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.client.ContractDefinitionClient;
import java.util.logging.Logger;

/**
 * The type Delete contract.
 */
public class DeleteContract {

    private static final Logger log = Logger.getLogger(DeleteContract.class.getName());

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

        contracts.delete("contract-def-1");

        log.info("Deleted contract definition: contract-def-1");
    }
}
