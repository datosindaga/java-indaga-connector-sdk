package es.itg.flythings.dataspace.sdk.examples.resources.negotiations;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.client.ContractNegotiationClient;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.dto.ContractRequestDTO;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.dto.OfferDTO;
import java.util.logging.Logger;

/**
 * The type Create negotiation.
 */
public class CreateNegotiation {

    private static final Logger log = Logger.getLogger(CreateNegotiation.class.getName());

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

        var offer = new OfferDTO();
        offer.setId("offer-id:contract-def-1:provider-connector-id");
        offer.setAssigner("provider-connector-id");
        offer.setTarget("asset-todo-api-1");

        var request = new ContractRequestDTO();
        request.setCounterPartyAddress("https://provider.example.com/connector/api");
        request.setProtocol("dataspace-protocol-http");
        request.setPolicy(offer);

        var result = negotiations.create(request);

        log.info("Created negotiation with id: " + result.getId());
    }
}
