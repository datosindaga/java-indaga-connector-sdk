package es.itg.flythings.connector.services;

import es.itg.flythings.auth.config.SdkConfig;
import es.itg.flythings.connector.services.downloads.DownloadRequest;
import es.itg.flythings.connector.services.downloads.DownloadService;
import es.itg.flythings.dataspace.exceptions.SdkBadRequestException;
import es.itg.flythings.dataspace.exceptions.SdkServerException;
import es.itg.flythings.utils.TestConfig;
import feign.Logger.Level;
import org.junit.jupiter.api.Test;

class DownloadServiceTest {

    private final SdkConfig config;

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
    }

    @Test
    void getDownloads_shouldReturnDownloadResult_whenQueryIsValid()
        throws SdkBadRequestException, SdkServerException {
        var agreementId = TestConfig.get("test.agreement.id");
        var downloadService = new DownloadService(config);

        var result = downloadService.download(new DownloadRequest.Builder(agreementId).build());

        System.out.println(result);

    }

}
