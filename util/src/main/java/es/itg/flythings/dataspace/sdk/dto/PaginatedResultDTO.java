package es.itg.flythings.dataspace.sdk.dto;

import java.util.List;

public class PaginatedResultDTO<T> {

    private List<T> items;

    private Boolean hasMore;

    public PaginatedResultDTO() {
    }

    public PaginatedResultDTO(List<T> items, Boolean hasMore) {
        this.items = items;
        this.hasMore = hasMore;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
}
