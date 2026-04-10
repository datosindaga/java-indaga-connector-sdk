package es.itg.flythings.dataspace.sdk.services;

import es.itg.flythings.dataspace.sdk.config.SdkConfig;
import es.itg.flythings.dataspace.sdk.services.edrs.EdrRequest;
import es.itg.flythings.dataspace.sdk.services.edrs.EdrService;
import es.itg.flythings.utils.TestConfig;
import org.junit.jupiter.api.Test;

class EdrServiceTest {

    private final SdkConfig config;

    public EdrServiceTest() {
        this.config = SdkConfig.builder()
            .apiUrl(TestConfig.get("sdk.api.url"))
            .authApiUrl(TestConfig.get("sdk.auth.url"))
            .credentials(
                TestConfig.get("sdk.auth.username"),
                TestConfig.get("sdk.auth.password")
            )
            .build();
    }

    @Test
    void getEdrs_shouldReturnList_whenQueryIsValid() {
        var agreementId = TestConfig.get("test.agreement.id");
        var edrService = new EdrService(config);

        var res = edrService.getEdrs(new EdrRequest.Builder(agreementId).build());

        System.out.println(res);
    }

}
