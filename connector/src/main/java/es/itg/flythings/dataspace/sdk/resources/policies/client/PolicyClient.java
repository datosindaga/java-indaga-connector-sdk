package es.itg.flythings.dataspace.sdk.resources.policies.client;

import es.itg.flythings.dataspace.sdk.edc.dto.IdResponseDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.policies.dto.PolicyDefinitionInputDTO;
import es.itg.flythings.dataspace.sdk.resources.policies.dto.PolicyDefinitionOutputDTO;
import es.itg.flythings.dataspace.sdk.resources.policies.dto.PolicyEvaluationPlanDTO;
import es.itg.flythings.dataspace.sdk.resources.policies.dto.PolicyEvaluationPlanRequestDTO;
import es.itg.flythings.dataspace.sdk.resources.policies.dto.PolicyValidationResultDTO;
import es.itg.flythings.dataspace.sdk.dto.PaginatedResultDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * The interface Policy client.
 */
public interface PolicyClient {

    /**
     * Returns a list of Policies that fit the criteria of the query.
     *
     * @param query the query
     * @return the requests
     */
    @RequestLine("POST /v1/policydefinitions/request")
    @Headers("Content-Type: application/json")
    PaginatedResultDTO<PolicyDefinitionOutputDTO> request(QuerySpecDTO query);

    /**
     * Returns a Policy that matches the @id given.
     *
     * @param id the id
     * @return the policy
     */
    @RequestLine("GET /v1/policydefinitions/{id}")
    PolicyDefinitionOutputDTO getById(@Param("id") String id);

    /**
     * Creates a new Policy.
     *
     * @param input the policy
     * @return the id response
     */
    @RequestLine("POST /v1/policydefinitions")
    @Headers("Content-Type: application/json")
    IdResponseDTO create(PolicyDefinitionInputDTO input);

    /**
     * Edits a Policy.
     *
     * @param input the policy
     */
    @RequestLine("PUT /v1/policydefinitions")
    @Headers("Content-Type: application/json")
    void edit(PolicyDefinitionInputDTO input);

    /**
     * Deletes a Policy.
     *
     * @param id the id
     */
    @RequestLine("DELETE /v1/policydefinitions/{id}")
    void delete(@Param("id") String id);

    /**
     * Evaluates a Policy.
     *
     * @param id    the id
     * @param input the policy evaluation plan
     * @return the evaluation
     */
    @RequestLine("POST /v1/policydefinitions/{id}/evaluationplan")
    @Headers("Content-Type: application/json")
    PolicyEvaluationPlanDTO evaluate(@Param("id") String id, PolicyEvaluationPlanRequestDTO input);

    /**
     * Validates a Policy.
     *
     * @param id the id
     * @return the validation result
     */
    @RequestLine("POST /v1/policydefinitions/{id}/validate")
    PolicyValidationResultDTO validate(@Param("id") String id);


}
