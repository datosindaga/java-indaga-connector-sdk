package es.itg.flythings.dataspace.edc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import es.itg.flythings.dataspace.edc.enums.SortEnum;
import java.util.List;

/**
 * Query specification used to filter, sort, and paginate Asset or Catalog items.
 *
 * <p>This DTO represents the query model commonly used across EDC Management APIs. It supports
 * JSON-LD context binding, filtering expressions, and ordering options.</p>
 *
 * <p>QuerySpec allows clients to:</p>
 * <ul>
 *   <li>Define JSON-LD context for semantic filtering.</li>
 *   <li>Specify filtering criteria via {@link #filterExpression}.</li>
 *   <li>Control pagination using {@link #offset} and {@link #limit}.</li>
 *   <li>Sort results by a given field and order.</li>
 * </ul>
 */
public class QuerySpecDTO {

    /**
     * JSON-LD context for defining the semantic scope of the query.
     *
     * <p>Two representations are supported:</p>
     * <ol>
     *   <li>As an <b>object</b> — defining vocabularies inline:
     *     <pre>{@code
     * {
     *   "@vocab": "https://w3id.org/edc/v0.0.1/ns/"
     * }
     *     }</pre>
     *   </li>
     *   <li>As an <b>array</b> — referencing one or more external contexts:
     *     <pre>{@code
     * [
     *   "https://w3id.org/edc/connector/management/v0.0.1"
     * ]
     *     }</pre>
     *   </li>
     * </ol>
     *
     * <p>Both are valid depending on the connector configuration.</p>
     */
    @JsonProperty("@context")
    private Object context;

    /**
     * JSON-LD type of this query object, typically set to {@code QuerySpec}.
     */
    @JsonProperty("@type")
    private String type;

    /**
     * Zero-based offset indicating the index of the first element to return. Used for pagination.
     *
     * <p>Example: {@code 0}</p>
     */
    private Integer offset;

    /**
     * Maximum number of elements to return in a single page of results.
     *
     * <p>Example: {@code 50}</p>
     */
    private Integer limit;

    /**
     * The field name by which the results should be sorted. Must correspond to a valid attribute
     * within the target entity.
     *
     * <p>Example: {@code createdAt}</p>
     */
    private String sortField;

    /**
     * Sorting order to apply when sorting by {@link #sortField}. Accepts either
     * {@link SortEnum#ASC} (ascending) or {@link SortEnum#DESC} (descending).
     */
    private SortEnum sortOrder;

    /**
     * A list of filtering criteria applied to the query.
     *
     * <p>Each {@link CriterionDTO} defines a left operand, an operator, and a right operand.
     * Multiple criteria are combined using logical AND semantics.</p>
     *
     * <p>Example:</p>
     * <pre>{@code
     * [
     *   { "operandLeft": "properties.contentType", "operator": "=", "operandRight": "application/json" },
     *   { "operandLeft": "properties.version", "operator": ">", "operandRight": "1.0" }
     * ]
     * }</pre>
     */
    private List<CriterionDTO> filterExpression;

    /**
     * Instantiates a new Query spec dto.
     */
    public QuerySpecDTO() {
    }

    /**
     * Gets context.
     *
     * @return the context
     */
    public Object getContext() {
        return context;
    }

    /**
     * Sets context.
     *
     * @param context the context
     */
    public void setContext(Object context) {
        this.context = context;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets offset.
     *
     * @return the offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * Sets offset.
     *
     * @param offset the offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * Gets limit.
     *
     * @return the limit
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets limit.
     *
     * @param limit the limit
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Gets sort field.
     *
     * @return the sort field
     */
    public String getSortField() {
        return sortField;
    }

    /**
     * Sets sort field.
     *
     * @param sortField the sort field
     */
    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    /**
     * Gets sort order.
     *
     * @return the sort order
     */
    public SortEnum getSortOrder() {
        return sortOrder;
    }

    /**
     * Sets sort order.
     *
     * @param sortOrder the sort order
     */
    public void setSortOrder(SortEnum sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * Gets filter expression.
     *
     * @return the filter expression
     */
    public List<CriterionDTO> getFilterExpression() {
        return filterExpression;
    }

    /**
     * Sets filter expression.
     *
     * @param filterExpression the filter expression
     */
    public void setFilterExpression(List<CriterionDTO> filterExpression) {
        this.filterExpression = filterExpression;
    }
}
