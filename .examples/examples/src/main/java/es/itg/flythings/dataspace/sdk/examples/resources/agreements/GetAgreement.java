package es.itg.flythings.dataspace.sdk.examples.resources.agreements;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.clients.ContractAgreementClient;
import java.util.logging.Logger;

/**
 * The type Get agreement.
 */
public class GetAgreement {

    private static final Logger log = Logger.getLogger(GetAgreement.class.getName());

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

        var agreements = client.buildClient(ContractAgreementClient.class);

        var agreement = agreements.getById("agreement-id-1");

        log.info("Got agreement: " + agreement.getId());
    }
}
