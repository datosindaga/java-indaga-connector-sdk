package es.itg.flythings.dataspace.sdk.examples.resources.negotiations;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.client.ContractNegotiationClient;
import java.util.logging.Logger;

/**
 * The type Get negotiation.
 */
public class GetNegotiation {

    private static final Logger log = Logger.getLogger(GetNegotiation.class.getName());

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

        var negotiations = client.buildClient(ContractNegotiationClient.class);

        var negotiation = negotiations.getById("negotiation-id-1");

        log.info("Got negotiation: " + negotiation.getId() + ", state: " + negotiation.getState());
    }
}
