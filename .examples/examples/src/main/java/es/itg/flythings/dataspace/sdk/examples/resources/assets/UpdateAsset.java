package es.itg.flythings.dataspace.sdk.examples.resources.assets;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.HttpDataAddressDTO;
import es.itg.flythings.dataspace.sdk.resources.assets.client.AssetClient;
import es.itg.flythings.dataspace.sdk.resources.assets.dto.AssetInputDTO;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * The type Update asset.
 */
public class UpdateAsset {

    private static final Logger log = Logger.getLogger(UpdateAsset.class.getName());

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
        dataAddress.setJsonLdType("DataAddress");
        dataAddress.setType("HttpData");
        dataAddress.setBaseUrl("https://jsonplaceholder.typicode.com/todos");

        var asset = new AssetInputDTO();
        asset.setId("asset-todo-api-1");
        asset.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        asset.setType("Asset");
        asset.setId("99c6ae8e-32ee-4e11-804c-c4d64c36037f");
        asset.setProperties(Map.of(
            "title", "Updated Test TODO",
            "description", "Simple Updated ToDo Json sample for testing with a simple asset",
            "keywords", List.of("Test", "TODOs"),
            "offerType", "Available",
            "publicTitle", "Test TODO",
            "publicDescription", "Simple ToDo Json sample for testing with a simple asset",
            "theme", "Testing",
            "optOut", false
        ));
        asset.setPrivateProperties(Map.of(
            "authentication", "REST-API Endpoint"
        ));
        asset.setDataAddress(dataAddress);

        assets.update(asset);

        log.info("Updated asset: " + asset.getId());
    }
}
