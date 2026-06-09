package es.itg.flythings.dataspace.sdk.resources.contractagreements;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.clients.ContractAgreementClient;
import es.itg.flythings.utils.TestConfig;
import feign.Logger.Level;
import org.junit.jupiter.api.Test;

/**
 * The Contract agreements client test.
 */
class ContractAgreementsClientTest {

    private final ContractAgreementClient agreementClient;

    /**
     * Instantiates a new Contract agreements client test.
     */
    public ContractAgreementsClientTest() {
        var config = DataspaceClient.builder()
            .apiUrl(TestConfig.get("sdk.api.url"))
            .authApiUrl(TestConfig.get("sdk.auth.url"))
            .credentials(
                TestConfig.get("sdk.auth.username"),
                TestConfig.get("sdk.auth.password")
            )
            .debug(false, Level.FULL)
            .build();
        this.agreementClient = config.buildClient(ContractAgreementClient.class);
    }

    /**
     * Gets requests should return agreements when query is valid.
     */
    @Test
    void getRequests_shouldReturnAgreements_whenQueryIsValid() {
        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        var result = agreementClient.request(query);
        System.out.println(result);
        assertNotNull(result);
    }

    /**
     * Gets negotiation should return negotiation when query is valid.
     */
    @Test
    void getNegotiation_shouldReturnNegotiation_whenQueryIsValid() {
        var agreementId = TestConfig.get("test.agreement.id");
        var res = agreementClient.getNegotiationByAgreementId(agreementId);
        System.out.println(res);
        assertNotNull(res);
    }

    /**
     * Gets agreement should return agreement when query is valid.
     */
    @Test
    void getAgreement_shouldReturnAgreement_whenQueryIsValid() {
        var agreementId = TestConfig.get("test.agreement.id");
        var res = agreementClient.getById(agreementId);
        System.out.println(res);
        assertNotNull(res);
    }

}
