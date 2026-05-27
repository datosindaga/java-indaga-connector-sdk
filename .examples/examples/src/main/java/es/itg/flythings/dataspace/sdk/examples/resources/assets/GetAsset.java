package es.itg.flythings.dataspace.sdk.examples.resources.assets;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.assets.client.AssetClient;
import java.util.logging.Logger;

public class GetAsset {

    private static final Logger log = Logger.getLogger(GetAsset.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var assets = client.buildClient(AssetClient.class);

        var asset = assets.getById("asset-todo-api-1");

        log.info("Got asset: " + asset.getId());
    }
}
