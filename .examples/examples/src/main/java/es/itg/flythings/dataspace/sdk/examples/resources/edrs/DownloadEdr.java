package es.itg.flythings.dataspace.sdk.examples.resources.edrs;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.edrs.client.EDRCacheClient;
import java.io.IOException;
import java.util.logging.Logger;

public class DownloadEdr {

    private static final Logger log = Logger.getLogger(DownloadEdr.class.getName());

    public static void main(String[] args) throws IOException {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var edrs = client.buildClient(EDRCacheClient.class);

        try (var response = edrs.download("transfer-process-id-1");
             var stream = response.body().asInputStream()) {

            byte[] content = stream.readAllBytes();
            log.info("Downloaded " + content.length + " bytes via EDR transfer-process-id-1");
        }
    }
}
