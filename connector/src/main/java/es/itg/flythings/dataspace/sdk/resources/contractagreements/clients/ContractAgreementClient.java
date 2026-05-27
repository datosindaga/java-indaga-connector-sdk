package es.itg.flythings.dataspace.sdk.resources.contractagreements.clients;

import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.dto.ContractAgreementDTO;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.dto.ContractNegotiationDTO;
import es.itg.flythings.dataspace.sdk.dto.PaginatedResultDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * The Contract agreement client.
 */
public interface ContractAgreementClient {

    /**
     * Gets resources paginates by a given criteria.
     *
     * @param query the query
     * @return the list of resources that match the criteria
     */
    @RequestLine("POST /v1/contractagreements/request")
    @Headers("Content-Type: application/json")
    PaginatedResultDTO<ContractAgreementDTO> request(QuerySpecDTO query);

    /**
     * Gets an agreement by its id.
     *
     * @param id the id
     * @return the by id
     */
    @RequestLine("GET /v1/contractagreements/{id}")
    ContractAgreementDTO getById(@Param("id") String id);

    /**
     * Gets a negotiation by the agreement id.
     *
     * @param id the id
     * @return the negotiation by agreement id
     */
    @RequestLine("GET /v1/contractagreements/{id}/negotiation")
    ContractNegotiationDTO getNegotiationByAgreementId(@Param("id") String id);

}
