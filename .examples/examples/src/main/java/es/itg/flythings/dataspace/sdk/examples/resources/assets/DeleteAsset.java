package es.itg.flythings.dataspace.sdk.examples.resources.assets;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.assets.client.AssetClient;
import java.util.logging.Logger;

/**
 * The type Delete asset.
 */
public class DeleteAsset {

    private static final Logger log = Logger.getLogger(DeleteAsset.class.getName());

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

        assets.delete("asset-todo-api-1");

        log.info("Deleted asset: asset-todo-api-1");
    }
}
