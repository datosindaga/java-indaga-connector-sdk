package es.itg.flythings.dataspace.sdk.services.agreements;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.CriterionDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.clients.ContractAgreementClient;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.dto.ContractAgreementDTO;
import java.util.List;
import java.util.logging.Logger;


/**
 * High-level service that retrieves all agreements related to an asset.
 *
 * <h2>Usage with {@link DataspaceClient} (recommended)</h2>
 * <pre>{@code
 * var service = new AgreementService(config);
 *
 * List<ContractAgreementDTO> result = service.getAgreements(
 *         new AgreementRequest.Builder("my-asset-id").build()
 * );
 * }*</pre>
 *
 * <h2>Usage with manual clients (testing)</h2>
 * <pre>{@code
 * var service = new AgreementService(
 *         contractAgreementClient
 * );
 * }*</pre>
 */
public final class AgreementService {

    private static final Logger log = Logger.getLogger(AgreementService.class.getName());

    private final ContractAgreementClient agreementClient;

    /**
     * Creates a {@link AgreementService}, building all required clients from the provided
     * {@link DataspaceClient}.
     *
     * @param config the config
     */
    public AgreementService(DataspaceClient config) {
        this.agreementClient = config.buildClient(ContractAgreementClient.class);
    }

    /**
     * Creates a {@link AgreementService} with manually provided clients. Intended for testing or
     * advanced use cases.
     *
     * @param agreementClient the client
     */
    public AgreementService(ContractAgreementClient agreementClient) {
        this.agreementClient = agreementClient;
    }

    // ------------------------------------------------------------------ //
    //  Public API
    // ------------------------------------------------------------------ //

    /**
     * Gets all the contract agreements related to an asset
     *
     * @param request a {@link AgreementRequest} built via {@link AgreementRequest.Builder}
     * @return a list of {@link ContractAgreementDTO} associated with the asset
     */
    public List<ContractAgreementDTO> getAgreements(AgreementRequest request) {
        log.info("Fetching agreements for asset: " + request.assetId);

        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setContext(request.context);
        var criterion = new CriterionDTO();
        criterion.setType("Criterion");
        criterion.setOperandLeft("assetId");
        criterion.setOperator("=");
        criterion.setOperandRight(new ObjectMapper().valueToTree(request.assetId));
        query.setFilterExpression(List.of(criterion));

        return agreementClient.request(query).getItems();
    }

}
