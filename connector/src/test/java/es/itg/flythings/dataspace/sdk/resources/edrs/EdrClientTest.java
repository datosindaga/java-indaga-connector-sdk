package es.itg.flythings.dataspace.sdk.resources.edrs;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.itg.flythings.dataspace.sdk.config.SdkConfig;
import es.itg.flythings.dataspace.sdk.edc.dto.CriterionDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.edrs.client.EDRCacheClient;
import es.itg.flythings.dataspace.sdk.resources.edrs.dto.EndpointDataReferenceDTO;
import es.itg.flythings.utils.TestConfig;
import java.util.List;
import org.junit.jupiter.api.Test;

class EdrClientTest {

    private final EDRCacheClient edrsClient;

    public EdrClientTest() {
        var config = SdkConfig.builder()
            .apiUrl(TestConfig.get("sdk.api.url"))
            .authApiUrl(TestConfig.get("sdk.auth.url"))
            .credentials(
                TestConfig.get("sdk.auth.username"),
                TestConfig.get("sdk.auth.password")
            )
            .build();
        this.edrsClient = config.buildClient(EDRCacheClient.class);
    }

    @Test
    void getRequests_shouldReturnAssets_whenQueryIsValid() {
        var agreementId = TestConfig.get("test.agreement.id");
        var query = new QuerySpecDTO();
        query.setType("QuerySpec");
        query.setContext(List.of("https://w3id.org/edc/connector/management/v0.0.1"));
        var criterion = new CriterionDTO();
        criterion.setType("Criterion");
        criterion.setOperandLeft("agreementId");
        criterion.setOperator("=");
        criterion.setOperandRight(new ObjectMapper().valueToTree(agreementId));
        query.setFilterExpression(List.of(criterion));
        List<EndpointDataReferenceDTO> result = edrsClient.request(query);
        System.out.println(result);
        assertNotNull(result);

    }

}
