package es.itg.flythings.dataspace.sdk.resources.catalog.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.IOException;

/**
 * The type Term ref.
 */
@JsonDeserialize(using = TermRef.Deserializer.class)
@JsonSerialize(using = TermRef.Serializer.class)
public final class TermRef {

    @JsonProperty("@id")
    private final String id;

    private TermRef(String id) {
        this.id = id;
    }

    /**
     * Of term ref.
     *
     * @param id the id
     * @return the term ref
     */
    public static TermRef of(String id) {
        return new TermRef(id);
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
     * The type Deserializer.
     */
    public static final class Deserializer extends JsonDeserializer<TermRef> {

        @Override
        public TermRef deserialize(JsonParser p, DeserializationContext ctx) throws IOException {
            ObjectMapper mapper = (ObjectMapper) p.getCodec();
            JsonNode node = mapper.readTree(p);

            if (node == null || node.isNull()) {
                return null;
            }

            if (node.isTextual()) {
                return TermRef.of(node.textValue());
            }

            if (node.isObject()) {
                JsonNode id = node.get("@id");
                if (id != null && id.isTextual()) {
                    return TermRef.of(id.textValue());
                }
            }
            throw JsonMappingException.from(p, "TermRef must be string or {@id}");
        }
    }

    /**
     * The type Serializer.
     */
    public static final class Serializer extends JsonSerializer<TermRef> {

        @Override
        public void serialize(TermRef v, JsonGenerator gen, SerializerProvider sp)
            throws IOException {
            if (v == null || v.id == null) {
                gen.writeNull();
                return;
            }
            gen.writeStartObject();
            gen.writeStringField("@id", v.id);
            gen.writeEndObject();
        }
    }
}
