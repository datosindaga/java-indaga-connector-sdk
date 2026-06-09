package es.itg.flythings.dataspace.sdk.resources.contractnegotiation.client;

import es.itg.flythings.dataspace.sdk.edc.dto.IdResponseDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.contractagreements.dto.ContractAgreementDTO;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.dto.ContractNegotiationDTO;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.dto.ContractRequestDTO;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.dto.NegotiationStateDTO;
import es.itg.flythings.dataspace.sdk.resources.contractnegotiation.dto.TerminationNegotiationDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.List;

/**
 * The interface Contract negotiation client.
 */
public interface ContractNegotiationClient {

    /**
     * Request contract negotiations that fit the query.
     *
     * @param query the query
     * @return the requests
     */
    @RequestLine("POST /v1/contractnegotiations/request")
    @Headers("Content-Type: application/json")
    List<ContractNegotiationDTO> request(QuerySpecDTO query);

    /**
     * Gets a contract negotiation by id.
     *
     * @param id the id
     * @return the by id
     */
    @RequestLine("GET /v1/contractnegotiations/{id}")
    ContractNegotiationDTO getById(@Param("id") String id);

    /**
     * Gets a contract negotiation state by id.
     *
     * @param id the id
     * @return the by id
     */
    @RequestLine("GET /v1/contractnegotiations/{id}/state")
    NegotiationStateDTO getStateById(@Param("id") String id);

    /**
     * Gets a contract agreement by id.
     *
     * @param id the id
     * @return the by id
     */
    @RequestLine("GET /v1/contractnegotiations/{id}/agreement")
    ContractAgreementDTO getAgreement(@Param("id") String id);

    /**
     * Create contract negotiation.
     *
     * @param contract the contract
     * @return the id response dto
     */
    @RequestLine("POST /v1/contractnegotiations")
    @Headers("Content-Type: application/json")
    IdResponseDTO create(ContractRequestDTO contract);

    /**
     * Terminate contract negotiation.
     *
     * @param id          the contract id
     * @param termination the termination body
     */
    @RequestLine("POST /v1/contractnegotiations/{id}/terminate")
    @Headers("Content-Type: application/json")
    void terminate(@Param("id") String id, TerminationNegotiationDTO termination);

    /**
     * Hide contract negotiation.
     *
     * @param id the contract id
     */
    @RequestLine("POST /v1/contractnegotiations/{id}/hide")
    void hide(@Param("id") String id);

    /**
     * Delete contract definition.
     *
     * @param id the id
     */
    @RequestLine("DELETE /v1/contractnegotiations/{id}")
    void delete(@Param("id") String id);

}
