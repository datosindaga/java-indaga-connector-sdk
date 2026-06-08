package es.itg.flythings.dataspace.sdk.edc.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Polymorphic data address. Discriminated by the {@code type} property.
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    property = "type",
    defaultImpl = GenericDataAddressDTO.class,
    visible = true
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = HttpDataAddressDTO.class, name = "HttpData"),
    @JsonSubTypes.Type(value = HttpDataAddressDTO.class, name = "https://w3id.org/idsa/v4.1/HTTP"),
    @JsonSubTypes.Type(value = S3DataAddressDTO.class, name = "AmazonS3"),
    @JsonSubTypes.Type(value = AzureStorageDataAdressDTO.class, name = "AzureStorage")
})
public interface DataAddressDTO {

    /**
     * Concrete address mechanism, e.g. {@code "HttpData"}, {@code "AmazonS3"}.  @return  the type
     */
    String getType();

    /**
     * JSON-LD class name, typically {@code "DataAddress"}.  @return  the json ld type
     */
    String getJsonLdType();
}
