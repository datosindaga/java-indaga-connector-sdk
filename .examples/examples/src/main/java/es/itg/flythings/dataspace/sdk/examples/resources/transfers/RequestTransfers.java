package es.itg.flythings.dataspace.sdk.examples.resources.transfers;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
import java.util.List;
import java.util.logging.Logger;

public class RequestTransfers {

    private static final Logger log = Logger.getLogger(RequestTransfers.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var transfers = client.buildClient(TransferClient.class);

        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        query.setOffset(0);
        query.setLimit(50);

        var results = transfers.request(query);

        log.info("Found " + results.getItems().size() + " transfer processes");
        log.info("Has more: " + results.getHasMore());
        results.getItems().forEach(t -> log.info("  - " + t.getId() + " [" + t.getState() + "]"));
    }
}
