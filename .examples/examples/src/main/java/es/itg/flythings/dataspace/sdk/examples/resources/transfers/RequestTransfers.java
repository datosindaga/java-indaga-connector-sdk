package es.itg.flythings.dataspace.sdk.examples.resources.transfers;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
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
        query.setOffset(0);
        query.setLimit(50);

        var results = transfers.request(query);

        log.info("Found " + results.size() + " transfer processes");
        results.forEach(t -> log.info("  - " + t.getId() + " [" + t.getState() + "]"));
    }
}
