package es.itg.flythings.dataspace.sdk.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

@Schema(
    name = "PaginatedResultDTO",
    description = """
        Minimal paginated response used for incremental loading patterns, since EDC does not return the total of items.
        Contains the items returned in the current response and a flag indicating whether there are more items available after it
        This is less costful than making a COUNT query or making a new request returning 0 items        """)
public class PaginatedResultDTO<T> {

    @Schema(description = "Items returned in the current response.")
    private List<T> items;

    @Schema(description = "Whether more items are available after this response.", examples = {"true"})
    private Boolean hasMore;

    public PaginatedResultDTO() {
    }

    public PaginatedResultDTO(List<T> items, Boolean hasMore) {
        this.items = items;
        this.hasMore = hasMore;
    }

    /**
     * Creates a PaginatedResultDTO by comparing the result size against the requested limit.
     * If limit is null, hasMore is always false.
     */
    public static <T> PaginatedResultDTO<T> of(List<T> items, Integer limit) {
        boolean hasMore = limit != null && items.size() >= limit;
        return new PaginatedResultDTO<>(items, hasMore);
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
