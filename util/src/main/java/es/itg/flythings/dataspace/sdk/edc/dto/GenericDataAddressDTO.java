package es.itg.flythings.dataspace.sdk.edc.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;

/** Fallback data address for any unrecognized {@code type} value. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericDataAddressDTO implements DataAddressDTO {

    @JsonProperty("@type")
    private String jsonLdType;

    @JsonProperty("type")
    private String type;

    private Map<String, Object> additional = new HashMap<>();

    public GenericDataAddressDTO() {
    }

    @JsonAnySetter
    public void putAdditional(String key, Object value) {
        additional.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditional() {
        return additional;
    }

    public void setAdditional(Map<String, Object> additional) {
        this.additional = additional;
    }

    @Override
    public String getJsonLdType() {
        return jsonLdType;
    }

    public void setJsonLdType(String jsonLdType) {
        this.jsonLdType = jsonLdType;
    }

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}