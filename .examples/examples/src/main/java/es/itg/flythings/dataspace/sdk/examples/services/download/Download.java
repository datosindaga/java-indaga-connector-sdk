package es.itg.flythings.dataspace.sdk.examples.services.download;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.exceptions.SdkBadRequestException;
import es.itg.flythings.dataspace.sdk.exceptions.SdkServerException;
import es.itg.flythings.dataspace.sdk.services.downloads.DownloadRequest;
import es.itg.flythings.dataspace.sdk.services.downloads.DownloadService;
import java.util.logging.Logger;

/**
 * The type Download.
 */
public class Download {

    private static final Logger log = Logger.getLogger(Download.class.getName());

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws SdkBadRequestException the sdk bad request exception
     * @throws SdkServerException     the sdk server exception
     */
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

        log.info(
            "Downloaded " + result.fileContent().length + " bytes, transferId: " + result.id());
    }
}
