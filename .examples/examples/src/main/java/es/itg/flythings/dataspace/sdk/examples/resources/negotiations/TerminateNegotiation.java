package es.itg.flythings.dataspace.sdk.examples.resources.negotiations;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.client.ContractNegotiationClient;
import java.util.logging.Logger;

public class TerminateNegotiation {

    private static final Logger log = Logger.getLogger(TerminateNegotiation.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var negotiations = client.buildClient(ContractNegotiationClient.class);

        negotiations.terminate("negotiation-id-1");

        log.info("Terminated negotiation: negotiation-id-1");
    }
}
