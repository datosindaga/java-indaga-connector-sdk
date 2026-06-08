package es.itg.flythings.dataspace.sdk.examples.resources.assets;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.HttpDataAddressDTO;
import es.itg.flythings.dataspace.sdk.resources.assets.client.AssetClient;
import es.itg.flythings.dataspace.sdk.resources.assets.dto.AssetInputDTO;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The type Create asset.
 */
public class CreateAsset {

    private static final Logger log = Logger.getLogger(CreateAsset.class.getName());

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

        var dataAddress = new HttpDataAddressDTO();
        dataAddress.setType("HttpData");
        dataAddress.setBaseUrl("https://jsonplaceholder.typicode.com/todos");
        dataAddress.setProxyPath(true);
        dataAddress.setProxyQueryParams(true);

        var asset = new AssetInputDTO();
        asset.setId("asset-todo-api-1");
        asset.setProperties(Map.of(
            "name", "Todo API",
            "contentType", "application/json",
            "version", "1.0"
        ));
        asset.setDataAddress(dataAddress);

        var result = assets.create(asset);

        log.info("Created asset with id: " + result.getId());
    }
}
