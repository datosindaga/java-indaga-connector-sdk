package es.itg.flythings.connector.resources.contractagreements.clients;

import es.itg.flythings.connector.resources.contractagreements.dto.ContractAgreementDTO;
import es.itg.flythings.connector.resources.contractnegotiation.dto.ContractNegotiationDTO;
import es.itg.flythings.dataspace.edc.dto.QuerySpecDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.List;

public interface ContractAgreementClient {

    @RequestLine("POST /v1/contractagreements/request")
    @Headers("Content-Type: application/json")
    List<ContractAgreementDTO> request(QuerySpecDTO query);

    @RequestLine("GET /v1/contractagreements/{id}")
    ContractAgreementDTO getById(@Param("id") String id);

    @RequestLine("GET /v1/contractagreements/{id}/negotiation")
    ContractNegotiationDTO getNegotiationByAgreementId(@Param("id") String id);

}
