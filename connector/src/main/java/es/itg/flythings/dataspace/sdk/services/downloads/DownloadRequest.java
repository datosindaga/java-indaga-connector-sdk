package es.itg.flythings.dataspace.sdk.services.downloads;

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

    /**
     * The Agreement id. (Required)
     */
    final String agreementId;
    /**
     * The Protocol. (Optional)
     */
    final String protocol;
    /**
     * The Transfer type. (Optional)
     */
    final String transferType;
    /**
     * The Data address type. (Optional)
     */
    final String dataAddressType;
    /**
     * The Context. (Optional)
     */
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

    /**
     * The type Builder.
     */
    public static final class Builder {

        // Required
        private final String agreementId;

        // Optional
        private String protocol = DEFAULT_PROTOCOL;
        private String transferType = DEFAULT_TRANSFER_TYPE;
        private String dataAddressType = DEFAULT_DATA_ADDRESS_TYPE;
        private List<String> context = DEFAULT_CONTEXT;

        /**
         * Instantiates a new Builder.
         *
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
         *
         * @param protocol the protocol
         * @return the builder
         */
        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        /**
         * Overrides the transfer type. Defaults to {@code "HttpData-PULL"}.
         *
         * @param transferType the transfer type
         * @return the builder
         */
        public Builder transferType(String transferType) {
            this.transferType = transferType;
            return this;
        }

        /**
         * Overrides the data address type. Defaults to {@code "HttpProxy"}.
         *
         * @param dataAddressType the data address type
         * @return the builder
         */
        public Builder dataAddressType(String dataAddressType) {
            this.dataAddressType = dataAddressType;
            return this;
        }

        /**
         * Overrides the JSON-LD context. Defaults to the EDC management API v0.0.1 context.
         *
         * @param context the context
         * @return the builder
         */
        public Builder context(List<String> context) {
            this.context = context;
            return this;
        }

        /**
         * Build download request.
         *
         * @return the download request
         */
        public DownloadRequest build() {
            return new DownloadRequest(this);
        }
    }
}
