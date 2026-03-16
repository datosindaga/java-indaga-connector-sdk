package es.itg.flythings.connector.resources.edrs.client;

import es.itg.flythings.connector.resources.edrs.dto.EndpointDataReferenceDTO;
import es.itg.flythings.dataspace.edc.dto.DataAddressDTO;
import es.itg.flythings.dataspace.edc.dto.QuerySpecDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import feign.Response;
import java.util.List;

public interface EDRCacheClient {

    @RequestLine("POST /v1/edrs/request")
    @Headers("Content-Type: application/json")
    List<EndpointDataReferenceDTO> request(QuerySpecDTO query);

    @RequestLine("GET /v1/edrs/{id}")
    DataAddressDTO getAddress(@Param("id") String id);

    @RequestLine("GET /v1/edrs/{id}/download")
    Response download(@Param("id") String id);

    @RequestLine("DELETE /v1/edrs/{id}")
    void delete(@Param("id") String id);

}
