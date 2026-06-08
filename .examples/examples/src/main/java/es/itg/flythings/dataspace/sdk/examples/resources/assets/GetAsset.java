package es.itg.flythings.dataspace.sdk.examples.resources.assets;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.assets.client.AssetClient;
import java.util.logging.Logger;

/**
 * The type Get asset.
 */
public class GetAsset {

    private static final Logger log = Logger.getLogger(GetAsset.class.getName());

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

        var asset = assets.getById("asset-todo-api-1");

        log.info("Got asset: " + asset.getId());
    }
}
