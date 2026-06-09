package es.itg.flythings.dataspace.sdk.resources.catalog.dto;

import java.util.UUID;

/**
 * Filters the datasets obtained to only the one specified in this request. If null then all
 * datasets form all contacts will be returned.
 */
public class ContactRequestDTO {

    private UUID id;

    private String search;

    /**
     * Instantiates a new Contact request dto.
     */
    public ContactRequestDTO() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Gets search.
     *
     * @return the search
     */
    public String getSearch() {
        return search;
    }

    /**
     * Sets search.
     *
     * @param search the search
     */
    public void setSearch(String search) {
        this.search = search;
    }
}
