package es.itg.flythings.dataspace.sdk.examples.resources.negotiations;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.client.ContractNegotiationClient;
import java.util.logging.Logger;

public class GetNegotiationState {

    private static final Logger log = Logger.getLogger(GetNegotiationState.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var negotiations = client.buildClient(ContractNegotiationClient.class);

        var state = negotiations.getStateById("negotiation-id-1");

        log.info("Negotiation state: " + state.getState());
    }
}
