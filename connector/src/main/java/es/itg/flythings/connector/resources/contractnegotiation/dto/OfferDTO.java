package es.itg.flythings.connector.resources.contractnegotiation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Map;

/**
 * Represents an ODRL Offer defining permissions, prohibitions, and obligations for a specific asset
 * or participant.
 *
 * <p>
 * The Offer describes what actions are allowed or restricted and under which conditions, according
 * to the ODRL (Open Digital Rights Language) model.
 * </p>
 */
public class OfferDTO {

    @JsonProperty("@context")
    private Object context;

    @JsonProperty("@type")
    private String type;

    @JsonProperty("@id")
    private String id;

    private String assigner;

    private String target;

    private List<Map<String, Object>> permission;

    private List<Map<String, Object>> prohibition;

    private List<Map<String, Object>> obligation;

    /**
     * Instantiates a new Offer dto.
     */
    public OfferDTO() {
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
     * Gets assigner.
     *
     * @return the assigner
     */
    public String getAssigner() {
        return assigner;
    }

    /**
     * Sets assigner.
     *
     * @param assigner the assigner
     */
    public void setAssigner(String assigner) {
        this.assigner = assigner;
    }

    /**
     * Gets target.
     *
     * @return the target
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets target.
     *
     * @param target the target
     */
    public void setTarget(String target) {
        this.target = target;
    }

    /**
     * Gets permission.
     *
     * @return the permission
     */
    public List<Map<String, Object>> getPermission() {
        return permission;
    }

    /**
     * Sets permission.
     *
     * @param permission the permission
     */
    public void setPermission(List<Map<String, Object>> permission) {
        this.permission = permission;
    }

    /**
     * Gets prohibition.
     *
     * @return the prohibition
     */
    public List<Map<String, Object>> getProhibition() {
        return prohibition;
    }

    /**
     * Sets prohibition.
     *
     * @param prohibition the prohibition
     */
    public void setProhibition(List<Map<String, Object>> prohibition) {
        this.prohibition = prohibition;
    }

    /**
     * Gets obligation.
     *
     * @return the obligation
     */
    public List<Map<String, Object>> getObligation() {
        return obligation;
    }

    /**
     * Sets obligation.
     *
     * @param obligation the obligation
     */
    public void setObligation(List<Map<String, Object>> obligation) {
        this.obligation = obligation;
    }

}
