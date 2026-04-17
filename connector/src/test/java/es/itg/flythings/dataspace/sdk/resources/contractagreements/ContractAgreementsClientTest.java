package es.itg.flythings.dataspace.sdk.resources.contractagreements;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.clients.ContractAgreementClient;
import es.itg.flythings.utils.TestConfig;
import feign.Logger.Level;
import org.junit.jupiter.api.Test;

class ContractAgreementsClientTest {

    private final ContractAgreementClient agreementClient;

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

    @Test
    void getRequests_shouldReturnAgreements_whenQueryIsValid() {
        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        var result = agreementClient.request(query);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    void getNegotiation_shouldReturnNegotiation_whenQueryIsValid() {
        var agreementId = TestConfig.get("test.agreement.id");
        var res = agreementClient.getNegotiationByAgreementId(agreementId);
        System.out.println(res);
        assertNotNull(res);
    }

    @Test
    void getAgreement_shouldReturnAgreement_whenQueryIsValid() {
        var agreementId = TestConfig.get("test.agreement.id");
        var res = agreementClient.getById(agreementId);
        System.out.println(res);
        assertNotNull(res);
    }

}
