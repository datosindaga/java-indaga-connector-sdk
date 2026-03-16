package es.itg.flythings.connector.resources.transfers.client;

import es.itg.flythings.connector.resources.transfers.dto.SuspendTransferDTO;
import es.itg.flythings.connector.resources.transfers.dto.TransferProcessDTO;
import es.itg.flythings.connector.resources.transfers.dto.TransferRequestDTO;
import es.itg.flythings.dataspace.edc.dto.IdResponseDTO;
import es.itg.flythings.dataspace.edc.dto.QuerySpecDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.List;

public interface TransferClient {

    @RequestLine("POST /v1/transferprocess/request")
    @Headers("Content-Type: application/json")
    List<TransferProcessDTO> getRequests(QuerySpecDTO query);

    @RequestLine("GET /v1/transferprocess/{id}")
    TransferProcessDTO getById(@Param("id") String id);

    @RequestLine("POST /v1/transferprocess")
    @Headers("Content-Type: application/json")
    IdResponseDTO create(TransferRequestDTO asset);

    @RequestLine("POST /v1/transferprocess/{id}/resume")
    void resume(@Param("id") String id);

    @RequestLine("POST /v1/transferprocess/{id}/suspend")
    @Headers("Content-Type: application/json")
    void suspend(@Param("id") String id, SuspendTransferDTO suspendTransfer);

    @RequestLine("POST /v1/transferprocess/{id}/terminate")
    void terminate(@Param("id") String id);

    @RequestLine("POST /v1/transferprocess/{id}/deprovision")
    void deprovision(@Param("id") String id);
}
