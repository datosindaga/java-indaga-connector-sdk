package es.itg.flythings.dataspace.sdk.resources.catalog;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import es.itg.flythings.dataspace.sdk.config.SdkConfig;
import es.itg.flythings.dataspace.sdk.resources.catalog.client.CatalogClient;
import es.itg.flythings.dataspace.sdk.resources.catalog.dto.ContactRequestDTO;
import es.itg.flythings.utils.TestConfig;
import org.junit.jupiter.api.Test;

public class CatalogClientTests {

    private final CatalogClient client;

    public CatalogClientTests() {
        var config = SdkConfig.builder()
            .apiUrl(TestConfig.get("sdk.api.url"))
            .authApiUrl(TestConfig.get("sdk.auth.url"))
            .credentials(
                TestConfig.get("sdk.auth.username"),
                TestConfig.get("sdk.auth.password")
            )
            .build();
        this.client = config.buildClient(CatalogClient.class);
    }

    @Test
    void getContactCatalogs_shouldReturnCatalogs_whenQueryIsValid() {
        var result = client.getContactCatalogs(new ContactRequestDTO());
        assertNotNull(result);
    }

}
