package es.itg.flythings.dataspace.sdk.services;

import es.itg.flythings.dataspace.sdk.config.SdkConfig;
import es.itg.flythings.dataspace.sdk.exceptions.SdkBadRequestException;
import es.itg.flythings.dataspace.sdk.exceptions.SdkServerException;
import es.itg.flythings.dataspace.sdk.services.downloads.DownloadRequest;
import es.itg.flythings.dataspace.sdk.services.downloads.DownloadService;
import es.itg.flythings.utils.TestConfig;
import feign.Logger.Level;
import org.junit.jupiter.api.Test;

class DownloadServiceTest {

    private final SdkConfig config;
    private final DownloadService service;

    public DownloadServiceTest() {
        this.config = SdkConfig.builder()
            .apiUrl(TestConfig.get("sdk.api.url"))
            .authApiUrl(TestConfig.get("sdk.auth.url"))
            .credentials(
                TestConfig.get("sdk.auth.username"),
                TestConfig.get("sdk.auth.password")
            )
            .debug(false, Level.FULL)
            .build();
        this.service = config.buildService(DownloadService.class);
    }

    @Test
    void getDownloads_shouldReturnDownloadResult_whenQueryIsValid()
        throws SdkBadRequestException, SdkServerException {
        var agreementId = "a3fe7fee-b359-477c-ab9d-0f9671601bf4";

        var result = service.download(new DownloadRequest.Builder(agreementId).build());

        System.out.println(result);

    }

}
