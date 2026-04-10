package es.itg.flythings.dataspace.sdk.resources.assets;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import es.itg.flythings.dataspace.sdk.config.SdkConfig;
import es.itg.flythings.dataspace.sdk.edc.dto.DataAddressDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.assets.client.AssetClient;
import es.itg.flythings.dataspace.sdk.resources.assets.dto.AssetInputDTO;
import es.itg.flythings.dataspace.sdk.resources.assets.dto.AssetOutputDTO;
import es.itg.flythings.utils.TestConfig;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class AssetClientTests {

    private final AssetClient assetClient;

    public AssetClientTests() {
        var config = SdkConfig.builder()
            .apiUrl(TestConfig.get("sdk.api.url"))
            .authApiUrl(TestConfig.get("sdk.auth.url"))
            .credentials(
                TestConfig.get("sdk.auth.username"),
                TestConfig.get("sdk.auth.password")
            )
            .build();
        this.assetClient = config.buildClient(AssetClient.class);
    }

    @Test
    void getRequests_shouldReturnAssets_whenQueryIsValid() {
        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        List<AssetOutputDTO> result = assetClient.request(query);
        assertNotNull(result);
    }

    @Test
    void create_shouldReturnNewAsset_whenInputIsValid() {
        var input = new AssetInputDTO();
        input.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        input.setType("Asset");
        input.setProperties(Map.of(
            "title", "Test TODO",
            "description", "Simple ToDo Json sample for testing with a simple asset",
            "keywords", List.of("Test", "TODOs"),
            "offerType", "Available",
            "publicTitle", "Test TODO",
            "publicDescription", "Simple ToDo Json sample for testing with a simple asset",
            "theme", "Testing",
            "optOut", false
        ));
        input.setPrivateProperties(Map.of(
            "authentication", "REST-API Endpoint"
        ));
        var dataaddress = new DataAddressDTO();
        dataaddress.setType("DataAddress");
        dataaddress.setAddressType("HttpData");
        dataaddress.setBaseUrl("https://jsonplaceholder.typicode.com/todos");
        dataaddress.setAdditional(Map.of("authKey", "X-API-KEY", "authCode", "password"));
        input.setDataAddress(dataaddress);

        var id = assetClient.create(input);
        assertNotNull(id);
        assertNotNull(id.getId());

        assertDoesNotThrow(() -> assetClient.getById(id.getId()));

        assertDoesNotThrow(() -> assetClient.delete(id.getId()));
    }

}
