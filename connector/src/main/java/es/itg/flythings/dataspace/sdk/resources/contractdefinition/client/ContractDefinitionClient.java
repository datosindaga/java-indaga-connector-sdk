package es.itg.flythings.dataspace.sdk.resources.contractdefinition.client;

import es.itg.flythings.dataspace.sdk.edc.dto.IdResponseDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.dto.ContractDefinitionInputDTO;
import es.itg.flythings.dataspace.sdk.resources.contractdefinition.dto.ContractDefinitionOutputDTO;
import es.itg.flythings.dataspace.sdk.dto.PaginatedResultDTO;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * The interface Contract definition client.
 */
public interface ContractDefinitionClient {

    /**
     * Request contracts that fit the query.
     *
     * @param query the query
     * @return the requests
     */
    @RequestLine("POST /v1/contractdefinitions/request")
    @Headers("Content-Type: application/json")
    PaginatedResultDTO<ContractDefinitionOutputDTO> request(QuerySpecDTO query);

    /**
     * Gets a contract by id.
     *
     * @param id the id
     * @return the by id
     */
    @RequestLine("GET /v1/contractdefinitions/{id}")
    ContractDefinitionOutputDTO getById(@Param("id") String id);

    /**
     * Create id response dto.
     *
     * @param contract the contract
     * @return the id response dto
     */
    @RequestLine("POST /v1/contractdefinitions")
    @Headers("Content-Type: application/json")
    IdResponseDTO create(ContractDefinitionInputDTO contract);

    /**
     * Update contract definition, targets the contract that matches the inner id.
     *
     * @param asset the asset
     */
    @RequestLine("PUT /v1/contractdefinitions")
    @Headers("Content-Type: application/json")
    void update(ContractDefinitionInputDTO asset);

    /**
     * Change contract definition state.
     *
     * @param id          the id
     * @param targetState the target state
     */
    @RequestLine("PUT /v1/contractdefinitions/state/{id}")
    @Headers("Content-Type: text/plain")
    @Body("{targetState}")
    void changeState(@Param("id") String id, @Param("targetState") String targetState);

    /**
     * Delete contract definition.
     *
     * @param id the id
     */
    @RequestLine("DELETE /v1/contractdefinitions/{id}")
    void delete(@Param("id") String id);

}
