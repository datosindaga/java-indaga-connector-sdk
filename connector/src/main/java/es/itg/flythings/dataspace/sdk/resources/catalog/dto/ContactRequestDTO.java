package es.itg.flythings.dataspace.sdk.resources.catalog.dto;

import java.util.UUID;

/**
 * Filters the datasets obtained to only the one specified in this request. If null then all
 * datasets form all contacts will be returned.
 */
public class ContactRequestDTO {

    private UUID id;

    private String search;

    public ContactRequestDTO() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
