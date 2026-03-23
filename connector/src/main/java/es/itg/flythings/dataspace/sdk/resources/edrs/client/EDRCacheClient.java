package es.itg.flythings.dataspace.sdk.resources.edrs.client;

import es.itg.flythings.dataspace.sdk.edc.dto.DataAddressDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.edrs.dto.EndpointDataReferenceDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;
import java.util.List;

/**
 * The EDR Cache client.
 */
public interface EDRCacheClient {

    /**
     * Gets resources paginates by a given criteria.
     *
     * @param query the query
     * @return the list of resources that match the criteria
     */
    @RequestLine("POST /v1/edrs/request")
    @Headers("Content-Type: application/json")
    List<EndpointDataReferenceDTO> request(QuerySpecDTO query);

    /**
     * Gets an EDR address by the transfer id.
     *
     * @param id the id
     * @return the address
     */
    @RequestLine("GET /v1/edrs/{id}")
    DataAddressDTO getAddress(@Param("id") String id);

    /**
     * Download asset by the transfer id.
     *
     * @param id the id
     * @return the response
     */
    @RequestLine("GET /v1/edrs/{id}/download")
    Response download(@Param("id") String id);

    /**
     * Deletes by the transfer id.
     *
     * @param id the id
     */
    @RequestLine("DELETE /v1/edrs/{id}")
    void delete(@Param("id") String id);

}
