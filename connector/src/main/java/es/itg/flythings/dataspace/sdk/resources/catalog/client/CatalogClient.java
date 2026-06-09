package es.itg.flythings.dataspace.sdk.resources.catalog.client;

import es.itg.flythings.dataspace.sdk.resources.catalog.dto.CatalogDTO;
import es.itg.flythings.dataspace.sdk.resources.catalog.dto.CatalogRequestDTO;
import es.itg.flythings.dataspace.sdk.resources.catalog.dto.ContactRequestDTO;
import es.itg.flythings.dataspace.sdk.resources.catalog.dto.DatasetDTO;
import es.itg.flythings.dataspace.sdk.resources.catalog.dto.DatasetRequestDTO;
import es.itg.flythings.dataspace.sdk.resources.catalog.dto.DetailedDatasetDTO;
import feign.Headers;
import feign.RequestLine;
import java.util.List;

/**
 * The interface Catalog client.
 */
public interface CatalogClient {

    /**
     * Gets a single catalog specified.
     *
     * @param query the query
     * @return the requests
     */
    @RequestLine("POST /v1/catalog/request")
    @Headers("Content-Type: application/json")
    CatalogDTO getCatalog(CatalogRequestDTO query);

    /**
     * Gets dataset.
     *
     * @param query the query
     * @return the requests
     */
    @RequestLine("POST /v1/catalog/dataset/request")
    @Headers("Content-Type: application/json")
    DatasetDTO getDataset(DatasetRequestDTO query);

    /**
     * Gets all the contacts catalogs.
     *
     * @param query the query
     * @return the requests
     */
    @RequestLine("POST /v1/catalog/contacts/request")
    @Headers("Content-Type: application/json")
    List<DetailedDatasetDTO> getContactCatalogs(ContactRequestDTO query);

}
