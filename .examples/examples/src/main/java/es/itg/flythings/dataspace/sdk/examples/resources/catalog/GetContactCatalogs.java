package es.itg.flythings.dataspace.sdk.examples.resources.catalog;

import es.itg.flythings.dataspace.sdk.config.DataspaceClient;
import es.itg.flythings.dataspace.sdk.resources.catalog.client.CatalogClient;
import es.itg.flythings.dataspace.sdk.resources.catalog.dto.ContactRequestDTO;
import java.util.logging.Logger;

/**
 * The type Get contact catalogs.
 */
public class GetContactCatalogs {

    private static final Logger log = Logger.getLogger(GetContactCatalogs.class.getName());

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        var client = DataspaceClient.builder()
            .apiUrl("https://devdsconnector.flythings.io/connector/api")
            .authApiUrl("https://devdsconnector.flythings.io/auth/api")
            .credentials("changeme", "changeme")
            .build();

        var catalog = client.buildClient(CatalogClient.class);

        var request = new ContactRequestDTO();
        request.setSearch("todo");

        var datasets = catalog.getContactCatalogs(request);

        log.info("Found " + datasets.size() + " datasets across contacts");
        datasets.forEach(d -> log.info("  - " + d.getId()));
    }
}
