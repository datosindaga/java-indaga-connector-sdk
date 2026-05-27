package es.itg.flythings.dataspace.sdk.examples.services.download;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.exceptions.SdkBadRequestException;
import es.itg.flythings.dataspace.sdk.exceptions.SdkServerException;
import es.itg.flythings.dataspace.sdk.services.downloads.DownloadRequest;
import es.itg.flythings.dataspace.sdk.services.downloads.DownloadService;
import java.util.logging.Logger;

public class Download {

    private static final Logger log = Logger.getLogger(Download.class.getName());

    public static void main(String[] args) throws SdkBadRequestException, SdkServerException {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var download = client.buildService(DownloadService.class);

        var result = download.download(
            new DownloadRequest.Builder("a3fe7fee-b359-477c-ab9d-0f9671601bf4").build()
        );

        log.info("Downloaded " + result.fileContent().length + " bytes, transferId: " + result.id());
    }
}
