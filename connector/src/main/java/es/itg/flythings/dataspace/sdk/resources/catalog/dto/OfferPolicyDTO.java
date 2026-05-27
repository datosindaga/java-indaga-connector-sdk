package es.itg.flythings.dataspace.sdk.resources.catalog.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * Represents an ODRL Offer Policy containing profiles, permissions, prohibitions, and obligations.
 *
 * <p>
 * An OfferPolicy aggregates one or more ODRL rules (permissions, prohibitions, and obligations)
 * under a defined policy profile.
 * </p>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OfferPolicyDTO {

    @JsonProperty("@id")
    private String id;

    @JsonProperty("@type")
    private String type;

    private List<String> profile;

    @JsonProperty("odrl:permission")
    @JsonAlias({"permission"})
    private List<PolicyRuleDTO> permission;

    @JsonProperty("odrl:prohibition")
    @JsonAlias({"prohibition"})
    private List<PolicyRuleDTO> prohibition;

    @JsonProperty("odrl:obligation")
    @JsonAlias({"obligation"})
    private List<PolicyRuleDTO> obligation;

    /**
     * Instantiates a new Offer policy dto.
     */
    public OfferPolicyDTO() {
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
     * Gets profile.
     *
     * @return the profile
     */
    public List<String> getProfile() {
        return profile;
    }

    /**
     * Sets profile.
     *
     * @param profile the profile
     */
    public void setProfile(List<String> profile) {
        this.profile = profile;
    }

    /**
     * Gets permission.
     *
     * @return the permission
     */
    public List<PolicyRuleDTO> getPermission() {
        return permission;
    }

    /**
     * Sets permission.
     *
     * @param permission the permission
     */
    public void setPermission(
        List<PolicyRuleDTO> permission) {
        this.permission = permission;
    }

    /**
     * Gets prohibition.
     *
     * @return the prohibition
     */
    public List<PolicyRuleDTO> getProhibition() {
        return prohibition;
    }

    /**
     * Sets prohibition.
     *
     * @param prohibition the prohibition
     */
    public void setProhibition(
        List<PolicyRuleDTO> prohibition) {
        this.prohibition = prohibition;
    }

    /**
     * Gets obligation.
     *
     * @return the obligation
     */
    public List<PolicyRuleDTO> getObligation() {
        return obligation;
    }

    /**
     * Sets obligation.
     *
     * @param obligation the obligation
     */
    public void setObligation(
        List<PolicyRuleDTO> obligation) {
        this.obligation = obligation;
    }
}
