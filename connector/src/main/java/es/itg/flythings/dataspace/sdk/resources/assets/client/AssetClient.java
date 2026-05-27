package es.itg.flythings.dataspace.sdk.resources.assets.client;

import es.itg.flythings.dataspace.sdk.edc.dto.IdResponseDTO;
import es.itg.flythings.dataspace.sdk.edc.dto.QuerySpecDTO;
import es.itg.flythings.dataspace.sdk.resources.assets.dto.AssetInputDTO;
import es.itg.flythings.dataspace.sdk.resources.assets.dto.AssetOutputDTO;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.List;

/**
 * The interface Asset client.
 */
public interface AssetClient {

    /**
     * Gets requests.
     *
     * @param query the query
     * @return the requests
     */
    @RequestLine("POST /v1/assets/request")
    @Headers("Content-Type: application/json")
    List<AssetOutputDTO> request(QuerySpecDTO query);

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    @RequestLine("GET /v1/assets/{id}")
    AssetOutputDTO getById(@Param("id") String id);

    /**
     * Create id response dto.
     *
     * @param asset the asset
     * @return the id response dto
     */
    @RequestLine("POST /v1/assets")
    @Headers("Content-Type: application/json")
    IdResponseDTO create(AssetInputDTO asset);

    /**
     * Update asset, targets the asset that matches the inner id.
     *
     * @param asset the asset
     */
    @RequestLine("PUT /v1/assets")
    @Headers("Content-Type: application/json")
    void update(AssetInputDTO asset);

    /**
     * Delete.
     *
     * @param id the id
     */
    @RequestLine("DELETE /v1/assets/{id}")
    void delete(@Param("id") String id);
}
