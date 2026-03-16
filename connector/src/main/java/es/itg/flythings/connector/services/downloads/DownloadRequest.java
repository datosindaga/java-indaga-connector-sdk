package es.itg.flythings.connector.services.downloads;

import java.util.List;

/**
 * Parameters for the {@link DownloadService#download(DownloadRequest)} operation.
 *
 * <pre>{@code
 * DownloadRequest request = new DownloadRequest.Builder("my-agreement-id").build();
 *
 * // With overrides
 * DownloadRequest request = new DownloadRequest.Builder("my-agreement-id")
 *         .transferType("HttpData-PUSH")
 *         .dataAddressType("AmazonS3")
 *         .build();
 * }</pre>
 */
public final class DownloadRequest {

    private static final String DEFAULT_PROTOCOL = "dataspace-protocol-http";
    private static final String DEFAULT_TRANSFER_TYPE = "HttpData-PULL";
    private static final String DEFAULT_DATA_ADDRESS_TYPE = "HttpProxy";
    private static final List<String> DEFAULT_CONTEXT = List.of(
        "https://w3id.org/edc/connector/management/v0.0.1"
    );

    final String agreementId;
    final String protocol;
    final String transferType;
    final String dataAddressType;
    final List<String> context;

    private DownloadRequest(Builder builder) {
        this.agreementId = builder.agreementId;
        this.protocol = builder.protocol;
        this.transferType = builder.transferType;
        this.dataAddressType = builder.dataAddressType;
        this.context = builder.context;
    }

    // ------------------------------------------------------------------ //
    //  Builder
    // ------------------------------------------------------------------ //

    public static final class Builder {

        // Required
        private final String agreementId;

        // Optional
        private String protocol = DEFAULT_PROTOCOL;
        private String transferType = DEFAULT_TRANSFER_TYPE;
        private String dataAddressType = DEFAULT_DATA_ADDRESS_TYPE;
        private List<String> context = DEFAULT_CONTEXT;

        /**
         * @param agreementId the ID of a previously negotiated contract agreement (required)
         */
        public Builder(String agreementId) {
            if (agreementId == null || agreementId.isBlank()) {
                throw new IllegalArgumentException("agreementId is required");
            }
            this.agreementId = agreementId;
        }

        /**
         * Overrides the dataspace protocol. Defaults to {@code "dataspace-protocol-http"}.
         */
        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        /**
         * Overrides the transfer type. Defaults to {@code "HttpData-PULL"}.
         */
        public Builder transferType(String transferType) {
            this.transferType = transferType;
            return this;
        }

        /**
         * Overrides the data address type. Defaults to {@code "HttpProxy"}.
         */
        public Builder dataAddressType(String dataAddressType) {
            this.dataAddressType = dataAddressType;
            return this;
        }

        /**
         * Overrides the JSON-LD context. Defaults to the EDC management API v0.0.1 context.
         */
        public Builder context(List<String> context) {
            this.context = context;
            return this;
        }

        public DownloadRequest build() {
            return new DownloadRequest(this);
        }
    }
}
