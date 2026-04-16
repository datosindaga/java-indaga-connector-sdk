package es.itg.flythings.dataspace.sdk.edc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response containing the identifier of a newly created or registered item.
 *
 * <p>Commonly returned after POST or registration operations within the dataspace. Includes
 * JSON-LD metadata fields for semantic interoperability.</p>
 *
 * <p>This DTO is typically returned by POST endpoints after creating or registering an entity
 * such as an Asset, Policy, or ContractDefinition.</p>
 */
public class IdResponseDTO {

    /**
     * Unique identifier assigned to the newly created item.
     *
     * <p>Example: {@code urn:uuid:3b3c1a7e-482d-4c8a-8a22-1e7462a4c456}</p>
     */
    @JsonProperty("@id")
    private String id;

    /**
     * JSON-LD type of the response, typically matching the created entity type.
     */
    @JsonProperty("@type")
    private String type;

    /**
     * JSON-LD context defining the semantic namespace of the response.
     *
     * <p>Both object and array forms are supported:</p>
     * <ol>
     *   <li><b>Object form:</b>
     *     <pre>{@code
     * {
     *   "@vocab": "https://w3id.org/edc/v0.0.1/ns/"
     * }
     *     }</pre>
     *   </li>
     *   <li><b>Array form:</b>
     *     <pre>{@code
     * [
     *   "https://w3id.org/edc/connector/management/v0.0.1"
     * ]
     *     }</pre>
     *   </li>
     * </ol>
     *
     * <p>The connector may include this field to preserve JSON-LD compatibility.</p>
     */
    @JsonProperty("@context")
    private Object context;

    /**
     * Timestamp (epoch milliseconds, UTC) when the item was created.
     *
     * <p>Example: {@code 1735068134234}</p>
     */
    @JsonProperty("createdAt")
    private Long createdAt;

    /**
     * Instantiates a new Id response dto.
     */
    public IdResponseDTO() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
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
     * Gets created at.
     *
     * @return the created at
     */
    public Long getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets created at.
     *
     * @param createdAt the created at
     */
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
