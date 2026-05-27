package es.itg.flythings.dataspace.sdk.examples.resources.assets;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.assets.client.AssetClient;
import java.util.logging.Logger;

public class RequestAssets {

    private static final Logger log = Logger.getLogger(RequestAssets.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var assets = client.buildClient(AssetClient.class);

        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setOffset(0);
        query.setLimit(50);

        var results = assets.request(query);

        log.info("Found " + results.size() + " assets");
        results.forEach(a -> log.info("  - " + a.getId()));
    }
}
