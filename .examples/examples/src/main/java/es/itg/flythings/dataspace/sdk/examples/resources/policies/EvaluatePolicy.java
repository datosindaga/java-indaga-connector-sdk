package es.itg.flythings.dataspace.sdk.examples.resources.policies;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.policies.client.PolicyClient;
import es.itg.flythings.dataspace.sdk.resources.policies.dto.PolicyEvaluationPlanRequestDTO;
import java.util.logging.Logger;

public class EvaluatePolicy {

    private static final Logger log = Logger.getLogger(EvaluatePolicy.class.getName());

    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var policies = client.buildClient(PolicyClient.class);

        var request = new PolicyEvaluationPlanRequestDTO();
        request.setPolicyScope("catalog");

        var plan = policies.evaluate("policy-open-1", request);

        log.info("Evaluation plan for policy-open-1: " + plan);
    }
}
