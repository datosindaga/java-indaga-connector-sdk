package es.itg.flythings.dataspace.sdk.resources.transfers.client;

import es.itg.flythings.dataspace.sdk.edc.dto.IdResponseDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.transfers.dto.SuspendTransferDTO;
import es.itg.flythings.dataspace.sdk.resources.transfers.dto.TransferProcessDTO;
import es.itg.flythings.dataspace.sdk.resources.transfers.dto.TransferRequestDTO;
import es.itg.flythings.dataspace.sdk.dto.PaginatedResultDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * The Transfer client.
 */
public interface TransferClient {

    /**
     * Gets resources paginates by a given criteria.
     *
     * @param query the query
     * @return the list of resources that match the criteria
     */
    @RequestLine("POST /v1/transferprocess/request")
    @Headers("Content-Type: application/json")
    PaginatedResultDTO<TransferProcessDTO> request(QuerySpecDTO query);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the transfer
     */
    @RequestLine("GET /v1/transferprocess/{id}")
    TransferProcessDTO getById(@Param("id") String id);

    /**
     * Create a transfer.
     *
     * @param transfer the transfer
     * @return the id
     */
    @RequestLine("POST /v1/transferprocess")
    @Headers("Content-Type: application/json")
    IdResponseDTO create(TransferRequestDTO transfer);

    /**
     * Resume a transfer by its id.
     *
     * @param id the id
     */
    @RequestLine("POST /v1/transferprocess/{id}/resume")
    void resume(@Param("id") String id);

    /**
     * Suspend a transfer by its id.
     *
     * @param id              the id
     * @param suspendTransfer the suspend transfer
     */
    @RequestLine("POST /v1/transferprocess/{id}/suspend")
    @Headers("Content-Type: application/json")
    void suspend(@Param("id") String id, SuspendTransferDTO suspendTransfer);

    /**
     * Terminate a transfer by its id.
     *
     * @param id the id
     */
    @RequestLine("POST /v1/transferprocess/{id}/terminate")
    void terminate(@Param("id") String id);

    /**
     * Deprovision a transfer by its id.
     *
     * @param id the id
     */
    @RequestLine("POST /v1/transferprocess/{id}/deprovision")
    void deprovision(@Param("id") String id);
}
