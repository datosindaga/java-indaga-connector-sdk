package es.itg.flythings.dataspace.sdk.resources.transfers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
import es.itg.flythings.utils.TestConfig;
import org.junit.jupiter.api.Test;

/**
 * The Transfer client tests.
 */
public class TransferClientTests {

    private final TransferClient client;

    /**
     * Instantiates a new Transfer client tests.
     */
    public TransferClientTests() {
        var config = DataspaceClient.builder()
            .apiUrl(TestConfig.get("sdk.api.url"))
            .authApiUrl(TestConfig.get("sdk.auth.url"))
            .credentials(
                TestConfig.get("sdk.auth.username"),
                TestConfig.get("sdk.auth.password")
            )
            .build();
        this.client = config.buildClient(TransferClient.class);
    }

    /**
     * Gets by id should return transfer when query is valid.
     */
    @Test
    void getById_shouldReturnTransfer_whenQueryIsValid() {
        var result = client.getById(TestConfig.get("test.transfer.id"));
        assertNotNull(result);
    }

}
