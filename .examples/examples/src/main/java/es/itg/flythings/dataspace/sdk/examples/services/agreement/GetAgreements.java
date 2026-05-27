package es.itg.flythings.dataspace.sdk.examples.services.agreement;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.clients.ContractAgreementClient;
import es.itg.flythings.dataspace.sdk.services.agreements.AgreementRequest;
import es.itg.flythings.dataspace.sdk.services.agreements.AgreementService;
import java.util.logging.Logger;

public class GetAgreements {

    private static final Logger log = Logger.getLogger(GetAgreements.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var service = new AgreementService(client.buildClient(ContractAgreementClient.class));

        var results = service.getAgreements(
            new AgreementRequest.Builder("asset-todo-api-1").build()
        );

        log.info("Found " + results.size() + " agreements for asset asset-todo-api-1");
        results.forEach(a -> log.info("  - " + a.getId()));
    }
}
