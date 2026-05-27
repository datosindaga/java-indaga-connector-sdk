package es.itg.flythings.dataspace.sdk.examples.resources.catalog;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.catalog.client.CatalogClient;
import es.itg.flythings.dataspace.sdk.resources.catalog.dto.DatasetRequestDTO;
import java.util.List;
import java.util.logging.Logger;

public class GetDataset {

    private static final Logger log = Logger.getLogger(GetDataset.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var catalog = client.buildClient(CatalogClient.class);

        var request = new DatasetRequestDTO();
        request.setType("DatasetRequest");
        request.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        request.setId("asset-todo-api-1");
        request.setProtocol("dataspace-protocol-http");
        request.setCounterPartyAddress("https://provider.example.com/connector/api");
        request.setCounterPartyId("provider-connector-id");

        var dataset = catalog.getDataset(request);

        log.info("Dataset id: " + dataset.getId());
    }
}
