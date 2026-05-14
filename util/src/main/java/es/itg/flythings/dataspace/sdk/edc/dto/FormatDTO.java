package es.itg.flythings.dataspace.sdk.edc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * The type Format dto.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = FormatDTO.Deserializer.class)
@JsonSerialize(using = FormatDTO.Serializer.class)
public final class FormatDTO {

    @JsonProperty("@id")
    private final String id;

    private FormatDTO(String id) {
        this.id = id;
    }

    /**
     * Of format dto.
     *
     * @param idValue the id value
     * @return the format dto
     */
    public static FormatDTO of(String idValue) {
        return new FormatDTO(idValue);
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
     * As string.
     *
     * @return the string
     */
    public String asString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FormatDTO that)) {
            return false;
        }
        return java.util.Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id);
    }

    @Override
    public String toString() {
        return "FormatDTO{@id=" + id + "}";
    }

    /**
     * The Deserializer.
     */
    public static final class Deserializer extends StdDeserializer<FormatDTO> {

        /**
         * Instantiates a new Deserializer.
         */
        public Deserializer() {
            super(FormatDTO.class);
        }

        @Override
        public FormatDTO deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            JsonNode node = p.getCodec().readTree(p);

            if (node == null || node.isNull()) {
                return null; // or throw if truly required
            }

            // Case 1: plain string literal -> store into @id
            if (node.isTextual()) {
                return FormatDTO.of(node.textValue());
            }

            // Case 2: object -> extract @id (or some tolerant aliases), else fail
            if (node.isObject()) {
                JsonNode idNode = node.get("@id");
                if (idNode != null && idNode.isTextual()) {
                    return FormatDTO.of(idNode.textValue());
                }

                // (Optional) accept a loose "id" as a fallback
                JsonNode altId = node.get("id");
                if (altId != null && altId.isTextual()) {
                    return FormatDTO.of(altId.textValue());
                }

                // If you want to be permissive, you could stringify. I recommend failing fast:
                throw JsonMappingException.from(p,
                    "dct:format must be a string or an object with @id");
            }

            // Other JSON types are invalid for this field
            throw JsonMappingException.from(p,
                "dct:format must be a string or an object with @id");
        }
    }

    /**
     * The type Serializer.
     */
    public static final class Serializer extends JsonSerializer<FormatDTO> {

        @Override
        public void serialize(FormatDTO value, JsonGenerator gen, SerializerProvider serializers)
            throws IOException {
            if (value == null || value.getId() == null) {
                gen.writeNull();
                return;
            }
            gen.writeStartObject();
            gen.writeStringField("@id", value.getId());
            gen.writeEndObject();
        }
    }

}
