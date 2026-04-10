package es.itg.flythings.dataspace.sdk.resources.transfers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import es.itg.flythings.dataspace.sdk.config.SdkConfig;
import es.itg.flythings.dataspace.sdk.resources.transfers.client.TransferClient;
import es.itg.flythings.utils.TestConfig;
import org.junit.jupiter.api.Test;

public class TransferClientTests {

    private final TransferClient client;

    public TransferClientTests() {
        var config = SdkConfig.builder()
            .apiUrl(TestConfig.get("sdk.api.url"))
            .authApiUrl(TestConfig.get("sdk.auth.url"))
            .credentials(
                TestConfig.get("sdk.auth.username"),
                TestConfig.get("sdk.auth.password")
            )
            .build();
        this.client = config.buildClient(TransferClient.class);
    }

    @Test
    void getById_shouldReturnTransfer_whenQueryIsValid() {
        var result = client.getById(TestConfig.get("test.transfer.id"));
        assertNotNull(result);
    }

}
