package es.itg.flythings.dataspace.sdk.services;

import es.itg.flythings.dataspace.sdk.config.SdkConfig;
import es.itg.flythings.dataspace.sdk.exceptions.SdkBadRequestException;
import es.itg.flythings.dataspace.sdk.exceptions.SdkServerException;
import es.itg.flythings.dataspace.sdk.services.transfers.TransferRequest;
import es.itg.flythings.dataspace.sdk.services.transfers.TransferService;
import es.itg.flythings.utils.TestConfig;
import org.junit.jupiter.api.Test;

class TransferServiceTest {

    private final SdkConfig config;

    public TransferServiceTest() {
        this.config = SdkConfig.builder()
            .apiUrl(TestConfig.get("sdk.api.url"))
            .authApiUrl(TestConfig.get("sdk.auth.url"))
            .credentials(
                TestConfig.get("sdk.auth.username"),
                TestConfig.get("sdk.auth.password")
            )
            .build();
    }

    @Test
    void getDownloads_shouldReturnDownloadResult_whenQueryIsValid()
        throws SdkBadRequestException, SdkServerException {
        var agreementId = TestConfig.get("test.agreement.id");
        var downloadService = new TransferService(config);

        var result = downloadService.startTransfer(
            new TransferRequest.Builder(agreementId).build());

        System.out.println(result);

    }

}
