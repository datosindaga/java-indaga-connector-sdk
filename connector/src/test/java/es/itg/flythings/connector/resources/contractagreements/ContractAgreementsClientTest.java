package es.itg.flythings.connector.resources.contractagreements;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import es.itg.flythings.auth.config.SdkConfig;
import es.itg.flythings.connector.resources.contractagreements.clients.ContractAgreementClient;
import es.itg.flythings.dataspace.edc.dto.QuerySpecDTO;
import es.itg.flythings.utils.TestConfig;
import feign.Logger.Level;
import org.junit.jupiter.api.Test;

class ContractAgreementsClientTest {

    private final ContractAgreementClient agreementClient;

    public ContractAgreementsClientTest() {
        var config = SdkConfig.builder()
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
