package es.itg.flythings.dataspace.sdk.examples.resources.assets;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.assets.client.AssetClient;
import java.util.List;
import java.util.logging.Logger;

/**
 * The type Request assets.
 */
public class RequestAssets {

    private static final Logger log = Logger.getLogger(RequestAssets.class.getName());

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

        var assets = client.buildClient(AssetClient.class);

        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        query.setOffset(0);
        query.setLimit(50);

        var results = assets.request(query);

        log.info("Found " + results.getItems().size() + " assets");
        log.info("Has more: " + results.getHasMore());
        results.getItems().forEach(a -> log.info("  - " + a.getId()));
    }
}
