package es.itg.flythings.dataspace.sdk.examples.resources.negotiations;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.client.ContractNegotiationClient;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.dto.TerminationNegotiationDTO;
import java.util.List;
import java.util.logging.Logger;

/**
 * The type Terminate negotiation.
 */
public class TerminateNegotiation {

    private static final Logger log = Logger.getLogger(TerminateNegotiation.class.getName());

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

        var termination = new TerminationNegotiationDTO();
        termination.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        termination.setType("TerminateNegotiation");
        termination.setReason("Negotiation terminated by consumer request.");

        negotiations.terminate("negotiation-id-1", termination);

        log.info("Terminated negotiation: negotiation-id-1");
    }
}
