package es.itg.flythings.dataspace.sdk.services.edrs;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.CriterionDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.edrs.client.EDRCacheClient;
import es.itg.flythings.dataspace.sdk.resources.edrs.dto.EndpointDataReferenceDTO;
import es.itg.flythings.dataspace.sdk.services.downloads.DownloadRequest;
import es.itg.flythings.dataspace.sdk.services.downloads.DownloadResult;
import java.util.List;
import java.util.logging.Logger;


/**
 * High-level service that orchestrates EDC data downloads.
 *
 * <h2>Usage with {@link DataspaceClient} (recommended)</h2>
 * <pre>{@code
 * var service = new DownloadService(config);
 *
 * DownloadResult result = service.download(
 *         new DownloadRequest.Builder("my-agreement-id").build()
 * );
 * }*</pre>
 *
 * <h2>With custom transfer configuration</h2>
 * <pre>{@code
 * DownloadResult result = service.download(
 *         new DownloadRequest.Builder("my-agreement-id")
 *                 .transferType("HttpData-PUSH")
 *                 .dataAddressType("AmazonS3")
 *                 .build()
 * );
 * }*</pre>
 *
 * <h2>Usage with manual clients (testing)</h2>
 * <pre>{@code
 * var service = new DownloadService(
 *         contractAgreementClient,
 *         transferClient,
 *         edrCacheClient
 * );
 * }*</pre>
 */
public final class EdrService {

    private static final Logger log = Logger.getLogger(EdrService.class.getName());

    private final EDRCacheClient edrCacheClient;

    /**
     * Creates a {@link EdrService}, building all required clients from the provided
     * {@link DataspaceClient}.
     *
     * @param config the config
     */
    public EdrService(DataspaceClient config) {
        this.edrCacheClient = config.buildClient(EDRCacheClient.class);
    }

    /**
     * Creates a {@link EdrService} with manually provided clients. Intended for testing or advanced
     * use cases.
     *
     * @param edrCacheClient the edr cache client
     */
    public EdrService(EDRCacheClient edrCacheClient) {
        this.edrCacheClient = edrCacheClient;
    }

    // ------------------------------------------------------------------ //
    //  Public API
    // ------------------------------------------------------------------ //

    /**
     * Executes the full download workflow for the given contract agreement.
     *
     * @param request a {@link DownloadRequest} built via {@link DownloadRequest.Builder}
     * @return a {@link DownloadResult} containing the filename and raw content bytes
     */
    public List<EndpointDataReferenceDTO> getEdrs(EdrRequest request) {
        log.info("Fetching EDRs for agreement: " + request.agreementId);

        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setContext(request.context);
        var criterion = new CriterionDTO();
        criterion.setType("Criterion");
        criterion.setOperandLeft("agreementId");
        criterion.setOperator("=");
        criterion.setOperandRight(new ObjectMapper().valueToTree(request.agreementId));
        query.setFilterExpression(List.of(criterion));

        return edrCacheClient.request(query);
    }

}
