package es.itg.flythings.dataspace.sdk.dto;

import java.util.List;

/**
 * The type Paginated result dto.
 *
 * @param <T> the type parameter
 */
public class PaginatedResultDTO<T> {

    private List<T> items;

    private Boolean hasMore;

    /**
     * Instantiates a new Paginated result dto.
     */
    public PaginatedResultDTO() {
    }

    /**
     * Instantiates a new Paginated result dto.
     *
     * @param items   the items
     * @param hasMore the has more
     */
    public PaginatedResultDTO(List<T> items, Boolean hasMore) {
        this.items = items;
        this.hasMore = hasMore;
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public List<T> getItems() {
        return items;
    }

    /**
     * Sets items.
     *
     * @param items the items
     */
    public void setItems(List<T> items) {
        this.items = items;
    }

    /**
     * Gets has more.
     *
     * @return the has more
     */
    public Boolean getHasMore() {
        return hasMore;
    }

    /**
     * Sets has more.
     *
     * @param hasMore the has more
     */
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
}
